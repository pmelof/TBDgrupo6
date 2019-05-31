package tbd.taller1.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import tbd.taller1.modelo.Genero;
import tbd.taller1.modelo.Personaje;

public interface GeneroRepositorio extends PagingAndSortingRepository<Genero, Integer> {
    Genero findPersonajeByGeneroId(Integer id);
}
