package tbd.taller1.modelo;

import java.sql.Date;

public class Temporada {

    private int temporada_id;
    private int nro_temporada;
    private Date fecha_estreno;

    //constructor.
    public Temporada(){}

    //get and set.
    public int getTemporada_id() {
        return temporada_id;
    }

    public void setTemporada_id(int temporada_id) {
        this.temporada_id = temporada_id;
    }

    public int getNro_temporada() {
        return nro_temporada;
    }

    public void setNro_temporada(int nro_temporada) {
        this.nro_temporada = nro_temporada;
    }

    public Date getFecha_estreno() {
        return fecha_estreno;
    }

    public void setFecha_estreno(Date fecha_estreno) {
        this.fecha_estreno = fecha_estreno;
    }
}
