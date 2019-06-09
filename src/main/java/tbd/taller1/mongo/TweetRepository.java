package tbd.taller1.mongo;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

@Repository
public interface TweetRepository extends MongoRepository<Tweet,Long>{
    List<Tweet> findAllByTextContaining(String name);
}
