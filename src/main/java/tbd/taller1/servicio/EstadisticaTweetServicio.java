package tbd.taller1.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.analizadorsentimental.ServicioAnalizadorSentimental;
import tbd.taller1.modelo.Actor;
import tbd.taller1.modelo.EstadisticaTweet;
import tbd.taller1.modelo.Personaje;
import tbd.taller1.modelo.Serie;
import tbd.taller1.mongo.Tweet;
import tbd.taller1.mongo.TweetRepository;
import tbd.taller1.mongo.TweetService;
import tbd.taller1.repositorio.*;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

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

        Iterable<Serie> series = new ArrayList<Serie>();
        series = this.serieRepositorio.findAll();


        int positivos=0;
        int neutros = 0;
        int negativos=0;

        System.out.println("########################## Series #############################\n");

        for(Serie serie:series){

            List<Tweet> tweets_series = this.tweetRepository.findAllByTextContaining(serie.getNombre());

            for (Tweet tweet:tweets_series) {

                int valor = servicioAnalizadorSentimental.classify(tweet.getText());

                if(valor == 1){ positivos++; }
                else if(valor == 0){neutros++;}
                else if(valor == -1){negativos++;}
                else if(valor == 99) {
                    System.out.println("ERROR ANALISIS SENTIMENTAL");
                    System.exit(0);
                }
            }
            System.out.println(serie.getNombre()+": "+ positivos+","+neutros+","+negativos);
        }


        // ########################################## BLOque de Codigo Seeder Actores ####################################

        Iterable<Actor> actores = new ArrayList<Actor>();
        actores = this.actorRepositorio.findAll();

        positivos=0;
        neutros = 0;
        negativos=0;

        System.out.println("########################## Actores #############################\n");
        for (Actor actor:actores) {

            List<Tweet> tweets_actores = this.tweetRepository.findAllByTextContaining(actor.getNombre());

            for (Tweet tweet:tweets_actores) {

                int valor = servicioAnalizadorSentimental.classify(tweet.getText());

                if(valor == 1){ positivos++; }
                else if(valor == 0){neutros++;}
                else if(valor == -1){negativos++;}
                else if(valor == 99) {
                    System.out.println("ERROR ANALISIS SENTIMENTAL");
                    System.exit(0);
                }
            }
            System.out.println(actor.getNombre()+": "+ positivos+","+neutros+","+negativos);
        }

        // ########################################## BLOque de Codigo Seeder Personajes ####################################

        Iterable<Personaje> personajes = new ArrayList<Personaje>();
        personajes = this.personajeRepositorio.findAll();

        positivos=0;
        neutros = 0;
        negativos=0;

        System.out.println("########################## Personajes #############################\n");

        for (Personaje personaje:personajes) {

            List<Tweet> tweets_personajes = this.tweetRepository.findAllByTextContaining(personaje.getNombre());

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
            System.out.println(personaje.getNombre()+": "+ positivos+","+neutros+","+negativos);
        }
    }










}
