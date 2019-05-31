package tbd.taller1.modelo;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table(name="temporada")
public class Temporada {

    @Id
    @Column (name="ID_temporada", unique=true, nullable=false)
    private int temporadaId;
    @Column (name="numero_temporada", nullable=false)
    private int nroTemporada;
    @Column (name="fecha_estreno", nullable=false)
    private int fechaEstreno;
    @Column (name="episodios", nullable=false)
    private int cantidadCapitulos;

    @ManyToOne
    @JoinColumn(name="ID_serie")
    private Serie serie;

    //constructor.
    public Temporada(){}

    //get and set.
    public int getTemporadaId() {
        return temporadaId;
    }

    public void setTemporadaId(int temporadaId) {
        this.temporadaId = temporadaId;
    }

    public int getNroTemporada() {
        return nroTemporada;
    }

    public void setNroTemporada(int nroTemporada) {
        this.nroTemporada = nroTemporada;
    }

    public int getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(int fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public int getCantidadCapitulos() {
        return cantidadCapitulos;
    }

    public void setCantidadCapitulos(int cantidadCapitulos) {
        this.cantidadCapitulos = cantidadCapitulos;
    }

    public int getIDSerie() {
        return serie.getSerieId();
    }

    public void setIDSerie(int ID_serie) {
        this.serie.setSerieId(ID_serie);
    }
}
