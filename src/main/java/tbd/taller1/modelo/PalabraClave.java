package tbd.taller1.modelo;

import javax.persistence.*;
import java.util.List;


@Entity
@Table(name="palabra_clave")
public class PalabraClave {

    @Id
    @Column(name="ID_palabra_clave", unique=true, nullable=false)
    private int palabraClaveId;
    @Column (name="palabra", nullable=false, length=32)
    private String palabra;

    @ManyToOne
    @JoinColumn(name="ID_serie")
    private Serie serie;

    @ManyToOne
    @JoinColumn(name="ID_personaje")
    private Personaje personaje;

    @ManyToOne
    @JoinColumn(name="ID_actor")
    private Actor actor;

 //   @ElementCollection
    @ManyToMany(mappedBy = "palabras_claves")
    List<Tweet> tweets;

    public PalabraClave(){}

    public int getPalabraClaveId() {
        return palabraClaveId;
    }

    public void setPalabraClaveId(int palabraClaveId) {
        this.palabraClaveId = palabraClaveId;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
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

    public List<Tweet> getTweets() {
        return tweets;
    }

    public void setTweets(List<Tweet> tweets) {
        this.tweets = tweets;
    }
}
