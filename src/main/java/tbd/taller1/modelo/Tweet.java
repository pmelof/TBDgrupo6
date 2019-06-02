package tbd.taller1.modelo;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="tweet")
public class Tweet {

    @Id
    @Column(name="ID_tweet", unique=true, nullable=false)
    private int tweetId;
    @Column (name="tweet", nullable=false, length=280)
    private String tweet;
    @Column (name="fecha_hora", nullable=false)
    private String fechaHora;
    @Column (name="geolocalizacion", nullable=false, length=225)
    private String geolocalizacion;

    @ManyToMany
    @JoinTable(name = "palabra_clave_tweet", joinColumns = @JoinColumn(name = "ID_tweet"), inverseJoinColumns = @JoinColumn(name = "ID_palabra_clave"))
    List<PalabraClave> palabras_claves;

    public Tweet(){}

    public int getTweetId() {
        return tweetId;
    }

    public void setTweetId(int tweetId) {
        this.tweetId = tweetId;
    }

    public String getTweet() {
        return tweet;
    }

    public void setTweet(String tweet) {
        this.tweet = tweet;
    }

    public String getFechaHora() {
        return fechaHora;
    }

    public void setFechaHora(String fechaHora) {
        this.fechaHora = fechaHora;
    }

    public String getGeolocalizacion() {
        return geolocalizacion;
    }

    public void setGeolocalizacion(String geolocalizacion) {
        this.geolocalizacion = geolocalizacion;
    }

    public List<PalabraClave> getPalabras_claves() {
        return palabras_claves;
    }

    public void setPalabras_claves(List<PalabraClave> palabras_claves) {
        this.palabras_claves = palabras_claves;
    }
}
