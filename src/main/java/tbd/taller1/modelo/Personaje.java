package tbd.taller1.modelo;

public class Personaje {

    private int personajeId;
    private String nombre;
    private int genero;

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

    public int getGenero() {
        return genero;
    }

    public void setGenero(int genero) {
        this.genero = genero;
    }
}
