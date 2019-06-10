package tbd.taller1.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="estadistica_tweet")
public class EstadisticaTweet {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="ID_estadistica_tweet", unique=true)
    private int estadisticaTweetId;
    @Column (name="nro_tweets")
    private int nroTweets;
    @Column (name="nro_tweets_positivos")
    private int nroTweetsPositivos;
    @Column (name="nro_tweets_negativos")
    private int nroTweetsNegativos;
    @Column (name="nro_tweets_neutros")
    private int nroTweetsNeutros;


    @OneToOne(mappedBy = "estadisticaTweetSerie")
    @JsonIgnore
    private Serie serie;

    @OneToOne(mappedBy = "estadisticaTweetPersonaje")
    @JsonIgnore
    private Personaje personaje;

    @OneToOne(mappedBy = "estadisticaTweetActor")
    @JsonIgnore
    private Actor actor;

    public EstadisticaTweet(){}

    public EstadisticaTweet(int nroTweets, int nroTweetsPositivos, int nroTweetsNegativos, int nroTweetsNeutros, Serie serie, Personaje personaje, Actor actor) {
        this.nroTweets = nroTweets;
        this.nroTweetsPositivos = nroTweetsPositivos;
        this.nroTweetsNegativos = nroTweetsNegativos;
        this.nroTweetsNeutros = nroTweetsNeutros;
        this.serie = serie;
        this.personaje = personaje;
        this.actor = actor;
    }

    public int getEstadisticaTweetId() {
        return estadisticaTweetId;
    }

    public void setEstadisticaTweetId(int estadisticaTweetId) {
        this.estadisticaTweetId = estadisticaTweetId;
    }

    public int getNroTweets() {
        return nroTweets;
    }

    public void setNroTweets(int nroTweets) {
        this.nroTweets = nroTweets;
    }

    public int getNroTweetsPositivos() {
        return nroTweetsPositivos;
    }

    public void setNroTweetsPositivos(int nroTweetsPositivos) {
        this.nroTweetsPositivos = nroTweetsPositivos;
    }

    public int getNroTweetsNegativos() {
        return nroTweetsNegativos;
    }

    public void setNroTweetsNegativos(int nroTweetsNegativos) {
        this.nroTweetsNegativos = nroTweetsNegativos;
    }

    public int getNroTweetsNeutros() {
        return nroTweetsNeutros;
    }

    public void setNroTweetsNeutros(int nroTweetsNeutros) {
        this.nroTweetsNeutros = nroTweetsNeutros;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Personaje getPersonaje() {
        return personaje;
    }

    public void setPersonaje(Personaje personaje) {
        this.personaje = personaje;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }
}
