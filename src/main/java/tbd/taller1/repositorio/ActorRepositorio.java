package tbd.taller1.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import tbd.taller1.modelo.Actor;

public interface ActorRepositorio extends PagingAndSortingRepository<Actor, Integer> {
    Actor findActorByActorId(Integer id);
}

