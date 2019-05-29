package tbd.taller1.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.modelo.Productor;
import tbd.taller1.repositorio.ProductorRepositorio;

@RestController
@RequestMapping("/productores")
@CrossOrigin(origins = "*")

public class ProductorServicio {

    @Autowired
    private ProductorRepositorio productorRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Productor> getAllUsers() {
        return productorRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Productor findOne(@PathVariable("id") Integer id) { return this.productorRepository.findProductorByProductorId(id);
    }
}
