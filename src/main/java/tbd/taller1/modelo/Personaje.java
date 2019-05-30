package tbd.taller1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="personaje")
public class Personaje {

    @Id
    @Column (name="ID_personaje", unique=true, nullable=false)
    private int personajeId;
    @Column (name="nombre", nullable=false, length=45)
    private String nombre;
    @Column (name="sexo", nullable=false)
    private int sexo;

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

    public int getSexo() {
        return sexo;
    }

    public void setSexo(int sexo) {
        this.sexo = sexo;
    }
}
