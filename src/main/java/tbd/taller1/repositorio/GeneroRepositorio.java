package tbd.taller1.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import tbd.taller1.modelo.Genero;

public interface GeneroRepositorio extends PagingAndSortingRepository<Genero, Integer> {
    Genero findGeneroByGeneroId(Integer id);
}
