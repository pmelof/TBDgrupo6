package tbd.taller1.servicio;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tbd.taller1.modelo.Tweet;
import tbd.taller1.repositorio.TweetRepositorio;

@RestController
@RequestMapping("/tweets")
@CrossOrigin(origins = "*")
public class TweetServicio {
    @Autowired
    private TweetRepositorio tweetRepository;

    @RequestMapping(method = RequestMethod.GET)
    @ResponseBody
    public Iterable<Tweet> getAllUsers() {
        return tweetRepository.findAll();
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    @ResponseBody
    public  Tweet findOne(@PathVariable("id") Integer id) { return this.tweetRepository.findTweetByTweetId(id);
    }
}
