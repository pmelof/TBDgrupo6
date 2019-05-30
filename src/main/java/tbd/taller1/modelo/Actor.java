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
    @Column (name="ID_actor", unique=true, nullable=false)
    private int actorId;
    @Column (name="nombre", nullable=false, length=45)
    private String nombre;
    @Column (name="sexo", nullable=false)
    private int sexo;

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

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }

/*   private static final long serialVersionUID = 1L;

    @Id
    @Column(name="actor_id", unique=true, nullable=false)
    private int actorId;

    @Column(name="first_name", nullable=false, length=45)
    private String firstName;

    @Column(name="last_name", nullable=false, length=45)
    private String lastName;

    @Column(name="last_update", nullable=false)
    private Timestamp lastUpdate;

    @ManyToMany
    @JoinTable(name = "film_actor", joinColumns = @JoinColumn(name = "actor_id"), inverseJoinColumns = @JoinColumn(name = "film_id"))
    List<Pelicula> peliculas;

    public Actor() {
        peliculas = new ArrayList<>();
    }

    public int getActorId() {
        return this.actorId;
    }

    public void setActorId(int actorId) {
        this.actorId = actorId;
    }

    public String getFirstName() {
        return this.firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return this.lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public Timestamp getLastUpdate() {
        return this.lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    public List<Pelicula> getPeliculas() {
        return peliculas;
    }

    public void setPeliculas(List<Pelicula> peliculas) {
        this.peliculas = peliculas;
    }*/
}