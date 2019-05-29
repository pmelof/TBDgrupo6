package tbd.taller1.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.modelo.*;
import tbd.taller1.repositorio.ActorRepositorio;
import tbd.taller1.repositorio.PeliculaRepositorio;

import java.sql.Timestamp;

@RestController
@RequestMapping("/actores")
@CrossOrigin(origins = "*")
public class ActorServicio {

    @Autowired
    private ActorRepositorio actorRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Actor> getAllUsers() {
        return actorRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Actor findOne(@PathVariable("id") Integer id) { return this.actorRepository.findActorByActorId(id);
    }


 //---------------------------------------------

   /* @Autowired
    private ActorRepositorio actorRepository;

    @Autowired
    private PeliculaRepositorio peliculaRepositorio;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Actor> getAllUsers() {
        return actorRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Actor findOne(@PathVariable("id") Integer id) { return this.actorRepository.findActorByActorId(id);
    }

    @RequestMapping(value = "/new", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    @ResponseBody
    public Actor create(@RequestBody Actor resource) {
        Timestamp time = new Timestamp(System.currentTimeMillis());
        resource.setLastUpdate(time);
        return actorRepository.save(resource);
    }

    @RequestMapping(value = "/{id}/films",method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Pelicula> peliculasActor(@PathVariable("id") Integer id) {
        Actor actor = actorRepository.findActorByActorId(id);
        return actor.getPeliculas();

    }*/

}
