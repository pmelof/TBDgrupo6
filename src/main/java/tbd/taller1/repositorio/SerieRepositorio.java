package tbd.taller1.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import tbd.taller1.modelo.Serie;

public interface SerieRepositorio extends PagingAndSortingRepository<Serie, Integer> {
    Serie findSerieBySerieId(Integer id);
}
