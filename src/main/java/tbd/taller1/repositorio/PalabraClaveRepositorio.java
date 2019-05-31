package tbd.taller1.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import tbd.taller1.modelo.PalabraClave;

public interface PalabraClaveRepositorio extends PagingAndSortingRepository<PalabraClave, Integer> {
    PalabraClave findPalabraClaveByPalabraId(Integer id);
}
