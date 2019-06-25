
package tbd.taller1.neo4j;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.TransactionWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import tbd.taller1.analizadorsentimental.ServicioAnalizadorSentimental;
import tbd.taller1.elasticsearch.ElasticsearchTweetRepository;
import tbd.taller1.elasticsearch.Tweet;
import tbd.taller1.modelo.Serie;
import tbd.taller1.repositorio.SerieRepositorio;

import javax.annotation.PostConstruct;

import java.util.ArrayList;
import java.util.List;

import static org.neo4j.driver.v1.Values.parameters;
@RestController
@RequestMapping("/neo4j")
public class Neo4jServicio {


    @Autowired
    private SerieRepositorio serieRepositorio;
    @Autowired
    private ElasticsearchTweetRepository elasticsearchTweetRepository;
    @Autowired
    private ServicioAnalizadorSentimental servicioAnalizadorSentimental;


    @PostConstruct
    public void SemilleroBD() {

        Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "neo4j", "1234" ) );
        Session session = driver.session();

        session.run("match (a)-[r]-(b) delete r");
        session.run("match (n) delete n");

        Iterable<Serie> series = this.serieRepositorio.findAll();

        for (Serie serie:series) {

            // INFO SERIE
            String nombreSerie = serie.getNombre();
            String emisorSerie = serie.getEmisor();

            // CREAR NODO SERIE
            session.run("CREATE (s:Serie {name:'" + nombreSerie + "',emisor:'" + emisorSerie + "'})");

            // BUSCAR TWEETS REFERENCIADO A LA SERIE CON ELASTIC SEARCH
            List<tbd.taller1.elasticsearch.Tweet> tweets_series = new ArrayList<>();
            for(String termino:serie.getNombre().split(" ")){
                tweets_series.addAll(this.elasticsearchTweetRepository.findTweetsByTextContaining(termino));
            }

            System.out.println("SERIE:     "+nombreSerie);

            int aux=0;
            for (Tweet tweet:tweets_series) {

                if(aux==20)break;
                // INFO USUARIO
                String usuarioTwitter = tweet.getUserScreenName();  // NOMBRE USUARIO
                int usuarioFollowers = tweet.getUserFollowersCount();


                // CREAR NODO USUARIO
                StatementResult verificacion = session.run("match (u:Usuario) where u.name='"+usuarioTwitter+"' return u.name as name, u.followers as followers");

                if(!verificacion.hasNext()){
                    session.run("CREATE(u:Usuario {name:'" + usuarioTwitter + "',followers:" + usuarioFollowers + "})");
                }
                // INFO TWEET
                String textTweet = tweet.getText();
                textTweet = textTweet.replaceAll("'","");

                // ANALISIS SENTIMENTAL AL TWEET DEL USUARIO
                int opinion = servicioAnalizadorSentimental.classify(textTweet);

                // CREAR RELACION USUARIO-TWITTER
                session.run("match (s:Serie) where s.name='"+nombreSerie+"'"
                    + "  match (u:Usuario) where u.name='"+usuarioTwitter+"'"
                    + "  create (u)-[label:opinion_serie {valorizacion:"+opinion+", text:'"+textTweet+"'}]->(s)");
                aux++;
            }
        }
        session.close();
        driver.close();
    }

    @RequestMapping(value = "/top={rank}", method = RequestMethod.GET)
    public ArrayList<Usuario> topUsuarios (@PathVariable("rank") Integer rank){

        Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "neo4j", "1234" ) );
        Session session = driver.session();

        StatementResult nodosUsuarios = session.run("MATCH (u:Usuario) return u.name as name, u.followers as followers order by followers desc limit "+rank);

        ArrayList<Usuario> usuariosNeo4j = new ArrayList<>();

        while ( nodosUsuarios.hasNext()){
            Record record = nodosUsuarios.next();
            String userName = record.get("name").toString().replace("\"","");
            int followers =  Integer.parseInt(record.get("followers").toString());
            Usuario usuario = new Usuario();
            usuario.setUserName(userName);
            usuario.setFollowers(followers);
            usuariosNeo4j.add(usuario);
        }
        session.close();
        driver.close();
        return usuariosNeo4j;
    }

    @RequestMapping(value = "/{serie}/top={rank}", method = RequestMethod.GET)
    public ArrayList<Usuario> topUsuariosBySerie (@PathVariable("serie") String serie,@PathVariable("rank") Integer rank){

        Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "neo4j", "1234" ) );
        Session session = driver.session();

        serie = serie.replace("_"," ");

        StatementResult nodosUsuarios = session.run("MATCH (u:Usuario) " +
                "match (s:Serie) where s.name='"+serie+"' " +
                "match (u)-[label]->(s)" +
                "return u.name as name, u.followers as followers order by followers desc limit "+rank);

        ArrayList<Usuario> usuariosNeo4j = new ArrayList<>();

        while ( nodosUsuarios.hasNext()){
            Record record = nodosUsuarios.next();
            String userName = record.get("name").toString().replace("\"","");
            int followers =  Integer.parseInt(record.get("followers").toString());
            Usuario usuario = new Usuario();
            usuario.setUserName(userName);
            usuario.setFollowers(followers);
            usuariosNeo4j.add(usuario);
        }
        session.close();
        driver.close();
        return usuariosNeo4j;
    }











}


