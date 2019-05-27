package tbd.taller1.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.modelo.Pelicula;
import tbd.taller1.repositorio.PeliculaRepositorio;

@RestController
@RequestMapping("/films")
public class PeliculaServicio {
    @Autowired
    private PeliculaRepositorio peliculaRepositorio;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Pelicula> getAllUsers() {
        return peliculaRepositorio.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Pelicula findOne(@PathVariable("id") Integer id) { return this.peliculaRepositorio.findFilmByFilmId(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Pelicula create(@RequestBody Pelicula resource) {
        return peliculaRepositorio.save(resource);
    }
}
