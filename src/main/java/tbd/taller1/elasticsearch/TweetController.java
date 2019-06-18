
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
	private ElasticsearchTweetRepository elasticsearchTweetRepository;
    //private TweetDao tweetDao;

    public TweetController(ElasticsearchTweetRepository elasticsearchTweetRepository) {
        this.elasticsearchTweetRepository = elasticsearchTweetRepository;
    }

    @GetMapping
	public String findAll(){
    	return elasticsearchTweetRepository.findAll().toString();
	}

	@GetMapping("/{id}")
	public Map<String, Object> getTweetById(@PathVariable String id){
	  return elasticsearchTweetRepository.getTweetById(id);
	}
	
	@PostMapping
	public Tweet insertTweet(@RequestBody Tweet tweet) throws Exception {
	  return elasticsearchTweetRepository.save(tweet);
	}
	
	@PutMapping("/{id}")
	public Tweet updateTweetById(@RequestBody Tweet tweet, @PathVariable String id) {
    	Tweet tweet1 = elasticsearchTweetRepository.findTweetById(id);
    	tweet1.setCountry(tweet.getCountry());
    	tweet1.setCountryCode(tweet.getCountryCode());
    	tweet1.setCreatedAt(tweet.getCreatedAt());
    	tweet1.setDownloadedAt(tweet.getDownloadedAt());
    	tweet1.setFavoriteCount(tweet.getFavoriteCount());
    	tweet1.setRetweetCount(tweet.getRetweetCount());
    	tweet1.setText(tweet.getText());
    	tweet1.setUserFavoritesCount(tweet.getUserFavoritesCount());
    	tweet1.setUserFollowersCount(tweet.getUserFollowersCount());
    	tweet1.setUserName(tweet.getUserName());
    	tweet1.setUserScreenName(tweet.getUserScreenName());
    	tweet1.setUserFollowersCount(tweet.getUserFollowersCount());
    	tweet1.setUserFavoritesCount(tweet.getUserFavoritesCount());
	  return elasticsearchTweetRepository.save(tweet1);
	}
	
	@DeleteMapping("/{id}")
	public void deleteTweetById(@PathVariable String id) {
	  elasticsearchTweetRepository.deleteById(id);
	}

}
