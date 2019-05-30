package tbd.taller1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="serie")
public class Serie {

    @Id
    @Column (name="ID_serie", unique=true, nullable=false)
    private int serieId;
    @Column (name="nombre", nullable=false, length=45)
    private String nombre;
    @Column (name="fecha_inicio", nullable=false)
    private int fechaInicio;
    @Column (name="fecha_fin", nullable=false)
    private  int fechaFin;
    @Column (name="sinopsis", nullable=false, length=2024)
    private  String sinopsis;
    @Column (name="emisor", nullable=false, length=45)
    private String emisor;  //nombre emisor.

    //constructor.
    public Serie(){}

    //get and set.
    public int getSerieId() {
        return serieId;
    }

    public void setSerieId(int serieId) {
        this.serieId = serieId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(int fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public int getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(int fechaFin) {
        this.fechaFin = fechaFin;
    }

    public String getSinopsis() {
        return sinopsis;
    }

    public void setSinopsis(String sinopsis) {
        this.sinopsis = sinopsis;
    }

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

}
