package tbd.taller1.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.modelo.PalabraClave;
import tbd.taller1.repositorio.PalabraClaveRepositorio;

@RestController
@RequestMapping("/palabrasClaves")
@CrossOrigin(origins = "*")
public class PalabraClaveServicio {
    @Autowired
    private PalabraClaveRepositorio palabraClaveRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<PalabraClave> getAllUsers() {
        return palabraClaveRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  PalabraClave findOne(@PathVariable("id") Integer id) { return this.palabraClaveRepository.findPalabraClaveByPalabraClaveId(id);
    }
}
