package tbd.taller1.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.modelo.EstadisticaTweet;
import tbd.taller1.repositorio.EstadisticaTweetRepositorio;

@RestController
@RequestMapping("/estadisticaTweets")
@CrossOrigin(origins = "*")
public class EstadisticaTweetServicio {

    @Autowired
    private EstadisticaTweetRepositorio estadisticaTweetRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<EstadisticaTweet> getAllUsers() {
        return estadisticaTweetRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  EstadisticaTweet findOne(@PathVariable("id") Integer id) { return this.estadisticaTweetRepository.findEstadisticaTweetsByEstadisticaTweetId(id);
    }


}
