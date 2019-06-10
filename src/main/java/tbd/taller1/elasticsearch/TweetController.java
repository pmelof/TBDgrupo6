
package tbd.taller1.elasticsearch;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@ComponentScan
@RestController
@EnableAutoConfiguration
@RequestMapping("/tuits")
public class TweetController {
    @Autowired
    private TweetDao tweetDao;

    public TweetController(TweetDao tweetDao) {
        this.tweetDao = tweetDao;
    }

	@GetMapping("/{id}")
	public Map<String, Object> getTweetById(@PathVariable String id){
	  return tweetDao.getTweetById(id);
	}
	
	@PostMapping
	public Tweet insertTweet(@RequestBody Tweet tweet) throws Exception {
	  return tweetDao.insertTweet(tweet);
	}
	
	@PutMapping("/{id}")
	public Map<String, Object> updateTweetById(@RequestBody Tweet tweet, @PathVariable String id) {
	  return tweetDao.updateTweetById(id, tweet);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTweetById(@PathVariable String id) {
	  tweetDao.deleteTweetById(id);
	}

}
