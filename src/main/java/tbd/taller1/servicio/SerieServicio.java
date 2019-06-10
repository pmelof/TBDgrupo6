package tbd.taller1.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.modelo.EstadisticaTweet;
import tbd.taller1.modelo.Serie;
import tbd.taller1.repositorio.SerieRepositorio;
import tbd.taller1.repositorio.EstadisticaTweetRepositorio;

@RestController
@RequestMapping("/series")
@CrossOrigin(origins = "*")

public class SerieServicio {

    @Autowired
    private SerieRepositorio serieRepository;

    @Autowired
    private EstadisticaTweetRepositorio estadisticaTweetRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Serie> getAllUsers() {
        return serieRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Serie findOne(@PathVariable("id") Integer id) { return this.serieRepository.findSerieBySerieId(id);
    }

    /*
    @RequestMapping(value = "/{id}/estadisticaSerie",method = RequestMethod.GET)
    @ResponseBody
    public Serie obtenerEstadisticaSerie(@PathVariable("id") Integer id) {
        Serie serie = serieRepository.findSerieBySerieId(id);
        EstadisticaTweet estadisticaSerie = estadisticaTweetRepository.findEstadisticaTweetsByEstadisticaTweetId(serie.getEstadisticaTweetSerie().getEstadisticaTweetId());
        serie.setEstadisticaTweetSerie(estadisticaSerie);
        return serie;
    }*/
}
