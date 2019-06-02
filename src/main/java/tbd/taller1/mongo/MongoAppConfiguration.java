package tbd.taller1.mongo;

import com.mongodb.MongoClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
@EnableConfigurationProperties(MongoProperties.class)
public class MongoAppConfiguration {
    @Autowired
    MongoProperties properties;

    @Bean
    public MongoTemplate mongoTemplate() throws Exception{
        MongoTemplate mongo = new MongoTemplate(new MongoClient(properties.getHost()),properties.getDatabase());
        return mongo;
    }
}
