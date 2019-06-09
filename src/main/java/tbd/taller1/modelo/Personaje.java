package tbd.taller1.modelo;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="personaje")
public class Personaje {

    @Id
    @Column (name="ID_personaje", unique=true, nullable=false)
    private int personajeId;
    @Column (name="nombre", nullable=false, length=45)
    private String nombre;

    @ManyToOne
    @JoinColumn(name="ID_serie")
    @JsonIgnore
    private Serie serie;

    @ManyToOne
    @JoinColumn(name = "ID_actor")
    @JsonIgnore
    private Actor actor;

    @OneToOne
    @JoinColumn(name = "ID_estadistica_tweet")
    private EstadisticaTweet estadisticaTweetPersonaje;

    //constructor.
    public Personaje(){}

    //get and set.
    public int getPersonajeId() {
        return personajeId;
    }

    public void setPersonajeId(int personajeId) {
        this.personajeId = personajeId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Serie getSerie() {
        return serie;
    }

    public void setSerie(Serie serie) {
        this.serie = serie;
    }

    public Actor getActor() {
        return actor;
    }

    public void setActor(Actor actor) {
        this.actor = actor;
    }

    public EstadisticaTweet getEstadisticaTweetPersonaje() {
        return estadisticaTweetPersonaje;
    }

    public void setEstadisticaTweetPersonaje(EstadisticaTweet estadisticaTweetPersonaje) {
        this.estadisticaTweetPersonaje = estadisticaTweetPersonaje;
    }
}
