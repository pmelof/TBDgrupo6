package tbd.taller1.modelo;

import javax.persistence.*;

@Entity
@Table(name="estadistica_tweet")
public class EstadisticaTweet {

    @Id
    @Column(name="ID_estadistica_tweet", unique=true, nullable=false)
    private int estadisticaTweetId;
    @Column (name="nro_tweets", nullable=false)
    private int nroTweets;
    @Column (name="nro_tweets_positivos", nullable=false)
    private int nroTweetsPositivos;
    @Column (name="nro_tweets_negativos", nullable=false)
    private int nroTweetsNegativos;
    @Column (name="nro_tweets_neutros", nullable=false)
    private int nroTweetsNeutros;

    @OneToOne
    @JoinColumn(name = "ID_serie")
    private Serie serie;

    @OneToOne
    @JoinColumn(name = "ID_personaje")
    private Personaje personaje;

    @OneToOne
    @JoinColumn(name = "ID_actor")
    private Actor actor;

}
