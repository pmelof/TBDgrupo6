package tbd.taller1.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="productor")
public class Productor {

    @Id
    @Column
    private int productorId;
    @Column
    private String nombre;
    @Column
    private String premio;      //los premios seran una lista de strings, o solo un texto?

    public Productor(){}

    public int getProductorId() {
        return productorId;
    }

    public void setProductorId(int productorId) {
        this.productorId = productorId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPremio() {
        return premio;
    }

    public void setPremio(String premio) {
        this.premio = premio;
    }
}
