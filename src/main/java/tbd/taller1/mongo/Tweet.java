package tbd.taller1.mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import twitter4j.Status;

import java.time.LocalDate;
import java.util.Date;

@Document(collection ="tweets")
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


    public Tweet(){}

    /*public Tweet(Date createdAt, LocalDate downloadedAt, int favoriteCount, int retweetCount, String text, String userScreenName, int userFavoritesCount, int userFollowersCount, String userName, String country, String countryCode) {

        this.createdAt = createdAt;
        this.downloadedAt = downloadedAt;
        this.favoriteCount = favoriteCount;
        this.retweetCount = retweetCount;
        this.text = text;
        this.userScreenName = userScreenName;
        this.userFavoritesCount = userFavoritesCount;
        this.userFollowersCount = userFollowersCount;
        this.userName = userName;
        this.country = country;
        this.countryCode = countryCode;
    }*/

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

    public Date getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Date createdAt) {
        this.createdAt = createdAt;
    }

    public LocalDate getDownloadedAt() {
        return downloadedAt;
    }

    public void setDownloadedAt(LocalDate downloadedAt) {
        this.downloadedAt = downloadedAt;
    }

    public int getFavoriteCount() {
        return favoriteCount;
    }

    public void setFavoriteCount(int favoriteCount) {
        this.favoriteCount = favoriteCount;
    }

    public int getRetweetCount() {
        return retweetCount;
    }

    public void setRetweetCount(int retweetCount) {
        this.retweetCount = retweetCount;
    }

    public String getUserScreenName() {
        return userScreenName;
    }

    public void setUserScreenName(String userScreenName) {
        this.userScreenName = userScreenName;
    }

    public int getUserFavoritesCount() {
        return userFavoritesCount;
    }

    public void setUserFavoritesCount(int userFavoritesCount) {
        this.userFavoritesCount = userFavoritesCount;
    }

    public int getUserFollowersCount() {
        return userFollowersCount;
    }

    public void setUserFollowersCount(int userFollowersCount) {
        this.userFollowersCount = userFollowersCount;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
