package tbd.taller1.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import tbd.taller1.modelo.Productor;

public interface ProductorRepositorio extends PagingAndSortingRepository<Productor, Integer> {
    Productor findProductorByProductorId(Integer id);
}
