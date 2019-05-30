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
    private Date fechaInicio;
    @Column (name="fecha_fin", nullable=false)
    private  Date fechaFin;
    @Column (name="sinopsis", nullable=false, length=1024)
    private  String sinopsis;
    @Column (name="genero", nullable=false, length=45)
    private  String genero;
    @Column (name="emisor", nullable=false, length=64)
    private String emisor;  //nombre emisor.
    @Column (name="plataforma", nullable=false)
    private int plataforma; // 1 y 0.

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

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
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

    public String getEmisor() {
        return emisor;
    }

    public void setEmisor(String emisor) {
        this.emisor = emisor;
    }

    public int getPlataforma() {
        return plataforma;
    }

    public void setPlataforma(int plataforma) {
        this.plataforma = plataforma;
    }
}
