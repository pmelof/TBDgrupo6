package tbd.taller1.neo4j;

public class Usuario {


    private String userName;
    private int followers;
    private String text;        //de la relación con la serie.
    private int valorizacion;   //de la relación con la serie.

    public Usuario(){}

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public int getFollowers() {
        return followers;
    }

    public void setFollowers(int followers) {
        this.followers = followers;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getValorizacion() {
        return valorizacion;
    }

    public void setValorizacion(int valorizacion) {
        this.valorizacion = valorizacion;
    }
}




