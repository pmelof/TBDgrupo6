package tbd.taller1.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.modelo.Personaje;
import tbd.taller1.repositorio.PersonajeRepositorio;

@RestController
@RequestMapping("/personajes")
@CrossOrigin(origins = "*")

public class PersonajeServicio {

    @Autowired
    private PersonajeRepositorio personajeRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Personaje> getAllUsers() {
        return personajeRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Personaje findOne(@PathVariable("id") Integer id) { return this.personajeRepository.findPersonajeByPersonajeId(id);
    }
}

