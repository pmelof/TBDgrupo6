package tbd.taller1.modelo;

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
    private Serie serie;

    @ManyToOne
    @JoinColumn(name = "ID_actor")
    private Actor actor;

    @OneToOne(mappedBy = "personaje")
    private EstadisticaTweet estadisticaTweet;

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

}
