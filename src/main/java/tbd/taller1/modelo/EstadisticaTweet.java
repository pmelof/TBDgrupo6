package tbd.taller1.modelo;

import javax.persistence.*;

@Entity
@Table(name="estadistica_tweet")
public class EstadisticaTweet {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
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

    @OneToOne(mappedBy = "estadisticaTweetSerie")
    private Serie serie;

    @OneToOne(mappedBy = "estadisticaTweetPersonaje")
    private Personaje personaje;

    @OneToOne(mappedBy = "estadisticaTweetActor")
    private Actor actor;
}
