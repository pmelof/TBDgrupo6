package tbd.taller1.modelo;

public class Productor {

    private int productorId;
    private String nombre;
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
