package tbd.taller1.mongo;

import org.springframework.stereotype.Repository;
import org.springframework.data.mongodb.repository.MongoRepository;

@Repository
public interface TweetRepository extends MongoRepository<Tweet,Long>{

}
