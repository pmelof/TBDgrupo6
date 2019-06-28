package tbd.taller1.servicio;

import org.neo4j.driver.v1.*;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.data.elasticsearch.core.query.NativeSearchQuery;
import org.springframework.data.elasticsearch.core.query.SearchQuery;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.analizadorsentimental.ServicioAnalizadorSentimental;
import tbd.taller1.elasticsearch.ElasticsearchTweetRepository;
import tbd.taller1.elasticsearch.Tweet;
import tbd.taller1.modelo.Actor;
import tbd.taller1.modelo.EstadisticaTweet;
import tbd.taller1.modelo.Personaje;
import tbd.taller1.modelo.Serie;
import tbd.taller1.mongo.TweetRepository;
import tbd.taller1.mongo.TweetService;
import tbd.taller1.repositorio.*;

import javax.annotation.PostConstruct;
import javax.websocket.Session;
import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;

import static java.sql.Types.NULL;
import static org.elasticsearch.index.query.QueryBuilders.matchQuery;


@RestController
@RequestMapping("/estadisticaTweets")
@CrossOrigin(origins = "*")
public class EstadisticaTweetServicio {

    @Autowired
    private EstadisticaTweetRepositorio estadisticaTweetRepository;
    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private SerieRepositorio serieRepositorio;
    @Autowired
    private ActorRepositorio actorRepositorio;
    @Autowired
    private PersonajeRepositorio personajeRepositorio;
    @Autowired
    private ElasticsearchTweetRepository elasticsearchTweetRepository;

    @Autowired
    TweetService tweetService;
    @Autowired
    ServicioAnalizadorSentimental servicioAnalizadorSentimental;


    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<EstadisticaTweet> getAllUsers() {
        return estadisticaTweetRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  EstadisticaTweet findOne(@PathVariable("id") Integer id) { return this.estadisticaTweetRepository.findEstadisticaTweetsByEstadisticaTweetId(id);
    }

    @PostConstruct
    public void SeederSqlStats(){

        // ########################################## BLOque de Codigo Seeder Series ####################################

        Iterable<Serie> series = this.serieRepositorio.findAll();

        //System.out.println("########################## Series #############################\n");


        int id=1;

        int positivos;
        int neutros;
        int negativos;

        for(Serie serie:series){

            positivos=0;
            neutros = 0;
            negativos=0;


            List<tbd.taller1.elasticsearch.Tweet> tweets_series = new ArrayList<>();
            for(String termino:serie.getNombre().split(" ")){
                 tweets_series.addAll(this.elasticsearchTweetRepository.findTweetsByTextContaining(termino));
            }



            for (tbd.taller1.elasticsearch.Tweet tweet:tweets_series) {

                int valor = servicioAnalizadorSentimental.classify(tweet.getText());

                if(valor == 1){ positivos++; }
                else if(valor == 0){neutros++;}
                else if(valor == -1){negativos++;}
                else if(valor == 99) {
                    System.out.println("ERROR ANALISIS SENTIMENTAL");
                    System.exit(0);
                }
            }
            //System.out.println(serie.getNombre()+": "+ positivos+","+neutros+","+negativos);

            EstadisticaTweet estadisticaTweet = new EstadisticaTweet();

            estadisticaTweet.setNroTweets(positivos+negativos+neutros);
            estadisticaTweet.setNroTweetsPositivos(positivos);
            estadisticaTweet.setNroTweetsNeutros(neutros);
            estadisticaTweet.setNroTweetsNegativos(negativos);


            serie.setEstadisticaTweetSerie(estadisticaTweet);
            serieRepositorio.save(serie);
        }

        // ########################################## BLOque de Codigo Seeder Actores ####################################

        Iterable<Actor> actores = this.actorRepositorio.findAll();


        //System.out.println("########################## Actores #############################\n");
        for (Actor actor:actores) {

            positivos=0;
            neutros = 0;
            negativos=0;

            List<tbd.taller1.elasticsearch.Tweet> tweets_actores = new ArrayList<>();
            for(String termino:actor.getNombre().split(" ")){
                 tweets_actores.addAll(this.elasticsearchTweetRepository.findAllByTextContaining(termino));
            }


            for (tbd.taller1.elasticsearch.Tweet tweet:tweets_actores) {

                int valor = servicioAnalizadorSentimental.classify(tweet.getText());

                if(valor == 1){ positivos++; }
                else if(valor == 0){neutros++;}
                else if(valor == -1){negativos++;}
                else if(valor == 99) {
                    System.out.println("ERROR ANALISIS SENTIMENTAL");
                    System.exit(0);
                }
            }
            //System.out.println(actor.getNombre()+": "+ positivos+","+neutros+","+negativos);

            EstadisticaTweet estadisticaTweet = new EstadisticaTweet();

            estadisticaTweet.setNroTweets(positivos+negativos+neutros);
            estadisticaTweet.setNroTweetsPositivos(positivos);
            estadisticaTweet.setNroTweetsNeutros(neutros);
            estadisticaTweet.setNroTweetsNegativos(negativos);

            actor.setEstadisticaTweetActor(estadisticaTweet);
            actorRepositorio.save(actor);
        }

        // ########################################## BLOque de Codigo Seeder Personajes ####################################

        Iterable<Personaje> personajes = this.personajeRepositorio.findAll();



        //System.out.println("########################## Personajes #############################\n");

        for (Personaje personaje:personajes) {
            positivos=0;
            neutros = 0;
            negativos=0;

            List<tbd.taller1.elasticsearch.Tweet> tweets_personajes = new ArrayList<>();
            for(String termino:personaje.getNombre().split(" ")){
                 tweets_personajes.addAll(this.elasticsearchTweetRepository.findAllByTextContaining(termino));
            }


            for (Tweet tweet:tweets_personajes) {

                int valor = servicioAnalizadorSentimental.classify(tweet.getText());

                if(valor == 1){ positivos++; }
                else if(valor == 0){neutros++;}
                else if(valor == -1){negativos++;}
                else if(valor == 99) {
                    System.out.println("ERROR ANALISIS SENTIMENTAL");
                    System.exit(0);
                }
            }
            //System.out.println(personaje.getNombre()+": "+ positivos+","+neutros+","+negativos);

            EstadisticaTweet estadisticaTweet = new EstadisticaTweet();

            estadisticaTweet.setNroTweets(positivos+negativos+neutros);
            estadisticaTweet.setNroTweetsPositivos(positivos);
            estadisticaTweet.setNroTweetsNeutros(neutros);
            estadisticaTweet.setNroTweetsNegativos(negativos);

            personaje.setEstadisticaTweetPersonaje(estadisticaTweet);
            personajeRepositorio.save(personaje);
        }
    }










}
