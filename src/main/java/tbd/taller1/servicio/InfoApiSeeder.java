package tbd.taller1.servicio;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import tbd.taller1.modelo.Pelicula;
import tbd.taller1.repositorio.*;

import java.util.ArrayList;

public class InfoApiSeeder {


    @Autowired
    private ActorRepositorio actorRepositorio;
    private EmisorRepositorio emisorRepositorio;
    private PeliculaRepositorio peliculaRepositorio;
    private PersonajeRepositorio personajeRepository;
    private ProductorRepositorio productorRepository;
    private SerieRepositorio serieRepository;
    private TemporadaRepositorio temporadaRepository;

    public void InfoApiSeeder(){


        HttpResponse<JsonNode> response;

        try {
            ArrayList<String> series = new ArrayList<String>();

            // AMC
            series.add("tt0903747");
            series.add("tt1520211");
            series.add("tt3032476");
            series.add("tt3743822");
            // Netflix
            series.add("tt4574334");
            series.add("tt4052886");
            series.add("tt0947798");
            series.add("tt3398228");
            //HBO
            series.add("tt7366338");
            series.add("tt0944947");
            series.add("tt0475784");
            series.add("tt2356777");

            response = Unirest.get("https://imdb8.p.rapidapi.com/title/get-details?tconst=tt0903747")
                    .header("X-RapidAPI-Host", "imdb8.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "c70c70ebd6msh50131f15ba91133p172d2djsn94648c5539a7")
                    .asJson();

            System.out.println(response.getBody().getObject().get("title"));
            Pelicula peli;

            /*for (String id:series) {


                // Serie
                   String nombre_serie;
                   int fecha_inicio_serie;
                   int fecha_final_serie;
                   String sinopsis;
                   String Emisor;

                // Temporada









                response = Unirest.get("https://imdb8.p.rapidapi.com/title/get-details?tconst="+id)
                        .header("X-RapidAPI-Host", "imdb8.p.rapidapi.com")
                        .header("X-RapidAPI-Key", "c70c70ebd6msh50131f15ba91133p172d2djsn94648c5539a7")
                        .asJson();
            }*/


        } catch (UnirestException e) {
            e.printStackTrace();
        }
















    }





































}
