package tbd.taller1.modelo;

import java.sql.Date;

public class Serie {

    private int serie_id;
    private String nombre;
    private Date fecha_inicio;
    private  Date fecha_fin;
    private  String sinopsis;
    private  String genero;

    //constructor.
    public Serie(){}

    //get and set.
    public int getSerieId() {
        return serie_id;
    }

    public void setSerieId(int serieId) {
        this.serie_id = serieId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Date getFecha_inicio() {
        return fecha_inicio;
    }

    public void setFecha_inicio(Date fecha_inicio) {
        this.fecha_inicio = fecha_inicio;
    }

    public Date getFecha_fin() {
        return fecha_fin;
    }

    public void setFecha_fin(Date fecha_fin) {
        this.fecha_fin = fecha_fin;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }
}
