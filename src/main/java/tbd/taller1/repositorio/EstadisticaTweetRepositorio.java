package tbd.taller1.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import tbd.taller1.modelo.EstadisticaTweet;

public interface EstadisticaTweetRepositorio extends PagingAndSortingRepository<EstadisticaTweet, Integer> {
    EstadisticaTweet findEstadisticaTweetsByEstadisticaTweetId(Integer id);
}
