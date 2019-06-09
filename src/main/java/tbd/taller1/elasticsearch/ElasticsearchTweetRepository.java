package tbd.taller1.elasticsearch;

import org.springframework.data.repository.CrudRepository;


public interface ElasticsearchTweetRepository extends CrudRepository<Tweet, String> {
    Tweet findByText(String text);
}

