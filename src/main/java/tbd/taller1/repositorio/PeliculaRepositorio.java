package tbd.taller1.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import tbd.taller1.modelo.Pelicula;

public interface PeliculaRepositorio extends PagingAndSortingRepository<Pelicula, Integer> {
  //  Pelicula findFilmByFilmId(Integer id);
}
