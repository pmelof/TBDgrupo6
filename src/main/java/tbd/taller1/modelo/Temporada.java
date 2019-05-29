package tbd.taller1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Date;

@Entity
@Table(name="temporada")
public class Temporada {

    @Id
    @Column
    private int temporadaId;
    @Column
    private int nroTemporada;
    @Column
    private Date fechaEstreno;
    @Column
    private int cantidadCapitulos;

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

    public Date getFechaEstreno() {
        return fechaEstreno;
    }

    public void setFechaEstreno(Date fechaEstreno) {
        this.fechaEstreno = fechaEstreno;
    }

    public int getCantidadCapitulos() {
        return cantidadCapitulos;
    }

    public void setCantidadCapitulos(int cantidadCapitulos) {
        this.cantidadCapitulos = cantidadCapitulos;
    }
}
