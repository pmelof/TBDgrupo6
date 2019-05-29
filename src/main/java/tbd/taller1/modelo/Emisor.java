package tbd.taller1.modelo;

public class Emisor {

    private int emisorId;
    private String nombre;
    private int plataforma;

    public Emisor(){}

    public int getEmisorId() {
        return emisorId;
    }

    public void setEmisorId(int emisorId) {
        this.emisorId = emisorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(int plataforma) {
        this.plataforma = plataforma;
    }
}
