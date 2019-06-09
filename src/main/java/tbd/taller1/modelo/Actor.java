package tbd.taller1.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;


@Entity
@Table(name="actor")
public class Actor implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column (name="ID_actor", unique=true, nullable=false)
    private int actorId;
    @Column (name="nombre", nullable=false, length=45)
    private String nombre;

    @OneToOne
    @JoinColumn(name = "ID_estadistica_tweet")
    private EstadisticaTweet estadisticaTweetActor;


    //constructor.
    public Actor(){}

    //get and set.
    public int getActorId() {
        return actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

}