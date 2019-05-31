package tbd.taller1.modelo;


import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="genero")
public class Genero {

    @Id
    @Column(name="ID_genero", unique=true, nullable=false)
    private int generoId;
    @Column (name="nombre", nullable=false, length=32)
    private String nombre;

    @ElementCollection
    @ManyToMany(mappedBy = "generos")
    List<Serie> series;

    public Genero(){}

    public int getGeneroId() {
        return generoId;
    }

    public void setGeneroId(int generoId) {
        this.generoId = generoId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
}
