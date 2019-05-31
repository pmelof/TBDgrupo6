package tbd.taller1.repositorio;

import org.springframework.data.repository.PagingAndSortingRepository;
import tbd.taller1.modelo.Tweet;

public interface TweetRepositorio extends PagingAndSortingRepository<Tweet, Integer> {
    Tweet findTweetByTweetId(Integer id);
}
