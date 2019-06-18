package tbd.taller1.elasticsearch;

import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public interface ElasticsearchTweetRepository extends ElasticsearchRepository<Tweet, String> {
    Map<String,Object> getTweetById(String id);
    Tweet findTweetById(String id);

}

