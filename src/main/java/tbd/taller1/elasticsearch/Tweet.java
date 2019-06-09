package tbd.taller1.elasticsearch;

import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import twitter4j.Status;

import java.time.LocalDate;
import java.util.Date;

public class Tweet {

    @Id
    private String id;

    private Date createdAt;
    private LocalDate downloadedAt;
    private int favoriteCount;
    private int retweetCount;
    private String text;
    private String userScreenName;
    private int userFavoritesCount;
    private int userFollowersCount;
    private String userName;
    private String country;
    private String countryCode;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Tweet(Status status){
        this.createdAt = status.getCreatedAt();
        this.favoriteCount = status.getFavoriteCount();
        this.retweetCount = status.getRetweetCount();
        this.text = status.getText();
        this.userScreenName = status.getUser().getScreenName();
        this.userFavoritesCount = status.getUser().getFavouritesCount();
        this.userFollowersCount = status.getUser().getFollowersCount();
        this.userName = status.getUser().getName();
        this.downloadedAt = LocalDate.now();
        if(status.getPlace() == null) {
            this.country = "Unknown";
            this.countryCode = "Unknown";
        } else {
            this.country = status.getPlace().getCountry();
            this.countryCode = status.getPlace().getCountryCode();
        }
    }
}
