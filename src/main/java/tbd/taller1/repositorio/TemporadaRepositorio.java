package tbd.taller1.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import tbd.taller1.modelo.Temporada;

public interface TemporadaRepositorio extends PagingAndSortingRepository<Temporada, Integer> {
    Temporada findTemporadaByTemporadaId(Integer id);
}
