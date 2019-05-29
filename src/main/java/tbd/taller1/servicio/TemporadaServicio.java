package tbd.taller1.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.modelo.Temporada;
import tbd.taller1.repositorio.TemporadaRepositorio;

@RestController
@RequestMapping("/temporadas")
@CrossOrigin(origins = "*")

public class TemporadaServicio {

    @Autowired
    private TemporadaRepositorio temporadaRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Temporada> getAllUsers() {
        return temporadaRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public Temporada findOne(@PathVariable("id") Integer id) { return this.temporadaRepository.findTemporadaByTemporadaId(id);
    }
}
