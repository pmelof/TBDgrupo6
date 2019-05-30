



package tbd.taller1.servicio;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.modelo.Serie;
import tbd.taller1.repositorio.*;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
@RestController
public class ApiService {


    @Autowired
    private ActorRepositorio actorRepositorio;
    @Autowired
    private PersonajeRepositorio personajeRepositorio;
    @Autowired
    private SerieRepositorio serieRepositorio;
    @Autowired
    private TemporadaRepositorio temporadaRepository;

    @PostConstruct
    public void ApiSeeder(){


        HttpResponse<JsonNode> responseIMDB;
        HttpResponse<JsonNode> responseIMDBalternative;


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


            int ID_serie = 1;
            int ID_temporada = 1;


            responseIMDBalternative = Unirest.get("https://movie-database-imdb-alternative.p.rapidapi.com/?i=tt0903747&r=json")
                    .header("X-RapidAPI-Host", "movie-database-imdb-alternative.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "c70c70ebd6msh50131f15ba91133p172d2djsn94648c5539a7")
                    .asJson();

            responseIMDB = Unirest.get("https://imdb8.p.rapidapi.com/title/get-details?tconst=tt0903747")
                    .header("X-RapidAPI-Host", "imdb8.p.rapidapi.com")
                    .header("X-RapidAPI-Key", "c70c70ebd6msh50131f15ba91133p172d2djsn94648c5539a7")
                    .asJson();

            String title = responseIMDB.getBody().getObject().get("title").toString();
            int fecha_inicio = Integer.parseInt(responseIMDB.getBody().getObject().get("seriesStartYear").toString());
            int fecha_fin = Integer.parseInt(responseIMDB.getBody().getObject().get("seriesEndYear").toString());
            String sinopsis = responseIMDBalternative.getBody().getObject().get("Plot").toString();



            Serie serie = new Serie();

            serie.setSerieId(ID_serie);
            serie.setNombre(title);
            serie.setFechaInicio(fecha_inicio);
            serie.setFechaFin(fecha_fin);
            serie.setSinopsis(sinopsis);
            serie.setEmisor("AMC");

            this.serieRepositorio.save(serie);




























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
            }
                */

        } catch (UnirestException e) {
            e.printStackTrace();
        }



    }

}
