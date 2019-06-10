package tbd.taller1.twitter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;
import tbd.taller1.elasticsearch.ElasticsearchTweetRepository;
import tbd.taller1.elasticsearch.TweetDao;
import tbd.taller1.mongo.Tweet;
import tbd.taller1.mongo.TweetRepository;
import twitter4j.*;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

@Service
@Configurable
public class TwitterListener {
    @Autowired
    private ResourceLoader resourceLoader;
    @Autowired
    private TwitterStream twitterStream;
    @Autowired
    private MongoTemplate mongo;
    @Autowired
    private TweetRepository tweetRepository;
    @Autowired
    private TweetDao tweetDao;

    @PostConstruct
    public void run() {
        twitterStream.addListener(new StatusListener() {
            public void onStatus(Status status) {
                if(!status.isRetweet()){
                    Tweet tweet = new Tweet(status);
                    tbd.taller1.elasticsearch.Tweet elasticTweet = new tbd.taller1.elasticsearch.Tweet(status);
                    System.out.println(tweetRepository.save(tweet));
                    System.out.println(tweetDao.insertTweet(elasticTweet));

                }
            }

            @Override
            public void onException(Exception arg0) {
            }

            @Override
            public void onDeletionNotice(StatusDeletionNotice arg0) {
            }

            @Override
            public void onScrubGeo(long arg0, long arg1) {
            }

            @Override
            public void onStallWarning(StallWarning arg0) {
            }

            @Override
            public void onTrackLimitationNotice(int arg0) {
            }
        });
        String[] bow=null;
        try {
            Resource resource=resourceLoader.getResource("classpath:bagofwords.txt");
            Scanner sc=new Scanner(resource.getFile());
            List<String> lines=new ArrayList<String>();
            while (sc.hasNextLine()) {
                lines.add(sc.nextLine());
            }
            bow=lines.toArray(new String[0]);
            sc.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        FilterQuery filter = new FilterQuery();
        filter.track(bow);
        filter.language(new String[]{"es"});
        twitterStream.filter(filter);
    }

    public TwitterStream getTwitterStream() {
        return twitterStream;
    }

    public void setTwitterStream(TwitterStream twitterStream) {
        this.twitterStream = twitterStream;
    }

    public MongoTemplate getMongo() {
        return mongo;
    }

    public void setMongo(MongoTemplate mongo) {
        this.mongo = mongo;
    }
}
