package tbd.taller1.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.modelo.Genero;
import tbd.taller1.repositorio.GeneroRepositorio;

@RestController
@RequestMapping("/generos")
@CrossOrigin(origins = "*")
public class GeneroServicio {
    @Autowired
    private GeneroRepositorio generoRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Genero> getAllUsers() {
        return generoRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Genero findOne(@PathVariable("id") Integer id) { return this.generoRepository.findGeneroByGeneroId(id);}

    }
