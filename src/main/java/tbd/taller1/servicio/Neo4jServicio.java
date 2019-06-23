
package tbd.taller1.servicio;

import org.neo4j.driver.v1.AuthTokens;
import org.neo4j.driver.v1.Driver;
import org.neo4j.driver.v1.GraphDatabase;
import org.neo4j.driver.v1.Record;
import org.neo4j.driver.v1.Session;
import org.neo4j.driver.v1.StatementResult;
import org.neo4j.driver.v1.Transaction;
import org.neo4j.driver.v1.TransactionWork;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import tbd.taller1.elasticsearch.ElasticsearchTweetRepository;
import tbd.taller1.modelo.Serie;
import tbd.taller1.repositorio.SerieRepositorio;

import javax.annotation.PostConstruct;

import static org.neo4j.driver.v1.Values.parameters;
@RestController
public class Neo4jServicio {


    @Autowired
    private SerieRepositorio serieRepositorio;
    @Autowired
    private ElasticsearchTweetRepository elasticsearchTweetRepository;



    @PostConstruct
    public void Neo4tester() {

        Driver driver = GraphDatabase.driver( "bolt://localhost", AuthTokens.basic( "neo4j", "1234" ) );
        Session session = driver.session();

        session.run("match (a)-[r]-(b) delete r");
        session.run("match (n) delete n");

        Iterable<Serie> series = this.serieRepositorio.findAll();

        for (Serie serie:series) {
            session.run("CREATE (s:Serie {name:'"+serie.getNombre()+"',emisor:'"+serie.getEmisor()+"'})");


            session.run("CREATE (u:User {name:'USUARIOTest',followers:'2000'})");


            //session.run("CREATE ("+serie.getNombre()+")-[label:Rela_Type {opinion:1, text:1}]-> (u)");



            session.run("match (s:Serie) where s.name='"+serie.getNombre()+"'"
                    + "  match (u:User) where u.name='USUARIOTest' "
                    + "  create (u)-[label:Rela_Type {opinion:'positivo', text:'ME GUSTA GOT'}]->(s)");

            break;
        }


        /*result = session.run( "MATCH (a:Person) return a.name as name, a.title as title");
        while ( result.hasNext() )
        {
            Record record = result.next();
            System.out.println( record.get( "title" ).asString() + " " + record.get("name").asString() );
        }*/




        /*session.run("match (a:Person) where a.name='Merlin'"
                + "match (b:Person) where b.name='Arthur'"
                + "create (a)-[r:Advise]->(b)");


        session.run("create (a:Person {name:'Guinevere',title:'Lady'})");

        session.run("match (a:Person) where a.name='Arthur'"
                + "match (b:Person) where b.name='Guinevere'"
                + "create (a)-[r:Married {since:'13 Century'}]->(b)");

        session.run("create (a:Person {name:'Percival',title:'Sir'})");
        session.run("create (a:Person {name:'Blanchefleur',title:'Lady'})");

        session.run("match (a:Person) where a.name='Percival'"
                + "match (b:Person) where b.name='Blanchefleur'"
                + "create (a)-[r:Married]->(b)");

        session.run("match (a:Person) where a.name='Percival'"
                + "match (b:Person) where b.name='Arthur'"
                + "create (a)-[r:Loyal]->(b)");

        session.run("match (a:Person) where a.name='Lancelot' "
                + "  match (b:Person) where b.name='Percival' "
                + "  create (a)-[r:Fellow]->(b)");*/

        //result = session.run( "MATCH (a:Person) where a.name='Lancelot' match (a)-[r]->(b:Person) return b.name as name, b.title as title");
        //result = session.run( "MATCH (a:Person) where a.name='Lancelot' match (a)-[r:]->(b:Person) return b.name as name, b.title as title");

        /*while ( result.hasNext() )
        {
            Record record = result.next();
            System.out.println( record.get( "title" ).asString() + " " + record.get("name").asString() );
            StatementResult result2 = session.run( "MATCH (a:Person) where a.name='"+record.get("name").asString()+"' match(a)-[r]->(b) return b.name as name, b.title as title");
            while ( result2.hasNext() )
            {
                record = result2.next();
                System.out.println(record.get( "title" ).asString() + " " + record.get("name").asString() );
            }
        }*/

        /*String[] names = new String[2];
        names[0] = "Galahad";
        names[1] = "Bors";

        for (String name:names)
        {
            session.run("create (a:Person {name:'"+name+"',title:'Sir'})");
            session.run("match (a:Person) where a.name='Lancelot'"
                    + "match (b:Person) where b.name='"+name+"'"
                    + "create (b)-[r:Fellow]->(a)");
            session.run("match (a:Person) where a.name='Arthur'"
                    + "match (b:Person) where b.name='"+name+"'"
                    + "create (b)-[r:Loyal]->(a)");
        }*/


        session.close();
        driver.close();

    }

}


