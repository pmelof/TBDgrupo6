package tbd.taller1.modelo;

import javax.persistence.*;


@Entity
@Table(name="palabra_clave")
public class PalabraClave {

    @Id
    @Column(name="ID_palabra_clave", unique=true, nullable=false)
    private int palabraClaveId;
    @Column (name="palabra", nullable=false, length=32)
    private String palabra;

    public PalabraClave(){}

    public int getPalabraClaveId() {
        return palabraClaveId;
    }

    public void setPalabraClaveId(int palabraClaveId) {
        this.palabraClaveId = palabraClaveId;
    }

    public String getPalabra() {
        return palabra;
    }

    public void setPalabra(String palabra) {
        this.palabra = palabra;
    }
}
