package tbd.taller1.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import tbd.taller1.modelo.Emisor;

public interface EmisorRepositorio extends PagingAndSortingRepository<Emisor, Integer> {
  //  Emisor findEmisorByEmisorId(Integer id);
}
