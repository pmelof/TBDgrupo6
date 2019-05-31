package tbd.taller1.servicio;

import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import com.mashape.unirest.http.exceptions.UnirestException;
import org.json.JSONException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.modelo.Actor;
import tbd.taller1.modelo.Genero;
import tbd.taller1.modelo.Serie;
import tbd.taller1.modelo.Temporada;
import tbd.taller1.repositorio.*;

import javax.annotation.PostConstruct;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
public class ApiServicio {

    @Autowired
    private ActorRepositorio actorRepositorio;
    @Autowired
    private PersonajeRepositorio personajeRepositorio;
    @Autowired
    private SerieRepositorio serieRepositorio;
    @Autowired
    private TemporadaRepositorio temporadaRepositorio;
    @Autowired
    private GeneroRepositorio generoRepositorio;

    @PostConstruct
    public void ApiSeeder(){


        /*HttpResponse<JsonNode> responseIMDB;
        HttpResponse<JsonNode> responseIMDBalternative;
        HttpResponse<JsonNode> responseTemporadas;

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
            series.add("tt5753856");
            series.add("tt3398228");
            //HBO
            series.add("tt7366338");
            series.add("tt0944947");
            series.add("tt0475784");
            series.add("tt2356777");

            int ID_serie = 1;
            int ID_temporada = 1;
            int ID_genero = 1;
            int ID_actor = 1;

            int contador=0;
            String emisor;
            String emisor1="AMC";
            String emisor2="NETFLIX";
            String emisor3="HBO";

            emisor = emisor1;

            for (String id_serie:series) {

                if(contador == 4){emisor=emisor2;}
                else if(contador == 8){emisor=emisor3;}



                responseIMDBalternative = Unirest.get("https://movie-database-imdb-alternative.p.rapidapi.com/?i="+id_serie+"&r=json")
                        .header("X-RapidAPI-Host", "movie-database-imdb-alternative.p.rapidapi.com")
                        .header("X-RapidAPI-Key", "c70c70ebd6msh50131f15ba91133p172d2djsn94648c5539a7")
                        .asJson();

                responseIMDB = Unirest.get("https://imdb8.p.rapidapi.com/title/get-details?tconst="+id_serie)
                        .header("X-RapidAPI-Host", "imdb8.p.rapidapi.com")
                        .header("X-RapidAPI-Key", "c70c70ebd6msh50131f15ba91133p172d2djsn94648c5539a7")
                        .asJson();

                String title = responseIMDB.getBody().getObject().get("title").toString();
                int fecha_inicio = Integer.parseInt(responseIMDB.getBody().getObject().get("seriesStartYear").toString());

                int fecha_fin;

                try {

                    fecha_fin = Integer.parseInt(responseIMDB.getBody().getObject().get("seriesEndYear").toString());

                }catch(JSONException e)
                {
                    fecha_fin = 0;
                }

                String sinopsis = responseIMDBalternative.getBody().getObject().get("Plot").toString();

                Serie serie = new Serie();

                serie.setSerieId(ID_serie);
                serie.setNombre(title);
                serie.setFechaInicio(fecha_inicio);
                serie.setFechaFin(fecha_fin);
                serie.setSinopsis(sinopsis);
                serie.setEmisor(emisor);


                //Obtener Generos de Serie


                String[] names_generos = responseIMDBalternative.getBody().getObject().get("Genre").toString().split(", ");

                for (String name_genero : names_generos) {

                    Genero genero = new Genero();
                    genero.setNombre(name_genero);
                    genero.setGeneroId(ID_genero);

                    this.generoRepositorio.save(genero);
                    ID_genero++;
                }

                String[] names_actores = responseIMDBalternative.getBody().getObject().get("Actors").toString().split(", ");

                for (String name_actor : names_actores) {

                    Actor actor = new Actor();
                    actor.setNombre(name_actor);
                    actor.setActorId(ID_actor);

                    this.actorRepositorio.save(actor);
                    ID_actor++;
                }

                this.serieRepositorio.save(serie);


                // Obtene Temporadas de Serie
                int cantidad_Temporadas = Integer.parseInt(responseIMDBalternative.getBody().getObject().get("totalSeasons").toString());

                responseTemporadas = Unirest.get("https://imdb8.p.rapidapi.com/title/get-seasons?tconst="+id_serie)
                        .header("X-RapidAPI-Host", "imdb8.p.rapidapi.com")
                        .header("X-RapidAPI-Key", "c70c70ebd6msh50131f15ba91133p172d2djsn94648c5539a7")
                        .asJson();


                for (int temp = 0; temp < cantidad_Temporadas; temp++) {

                    Temporada temporada = new Temporada();


                    int fecha_inicio_temp = Integer.parseInt(responseTemporadas.getBody().getArray().optJSONObject(temp).
                            getJSONArray("episodes").
                            optJSONObject(0).get("year").toString());

                    int cantidad_capitulos_temp = responseTemporadas.getBody().getArray().optJSONObject(temp).
                            getJSONArray("episodes").length();


                    temporada.setTemporadaId(ID_temporada);
                    temporada.setNroTemporada(temp + 1);
                    temporada.setFechaEstreno(fecha_inicio_temp);
                    temporada.setCantidadCapitulos(cantidad_capitulos_temp);


                    ID_temporada++;

                    this.temporadaRepositorio.save(temporada);
                }


                ID_serie++;
                contador++;
            }

        } catch (UnirestException e) {
            e.printStackTrace();
        }*/

    }
}
