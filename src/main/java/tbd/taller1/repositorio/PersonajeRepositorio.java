package tbd.taller1.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import tbd.taller1.modelo.Personaje;

public interface PersonajeRepositorio extends PagingAndSortingRepository<Personaje, Integer> {
    Personaje findPersonajeByPersonajeId(Integer id);
}
