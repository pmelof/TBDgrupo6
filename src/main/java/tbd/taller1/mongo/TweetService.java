package tbd.taller1.mongo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TweetService {
    @Autowired
    TweetRepository repository;

    @RequestMapping("/tweets")
    public List<Tweet> getTweets(){return repository.findAll();}
}
