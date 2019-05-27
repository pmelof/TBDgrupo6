package tbd.taller1.modelo;

//import org.springframework.data.annotation.Id;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "film")
public class Pelicula {

   @Id
   @Column(name="film_id", unique=true, nullable=false)
   private int filmId;

    @Column(name="title", nullable=false, length=45)
    private String title;

    @Column(name="description", nullable=false, length=50)
    private String description;

    @Column(name="release_year", nullable=false, length=50)
    private int release_year;

    @Column(name="last_update", nullable=false)
    private Timestamp lastUpdate;

    @ElementCollection
    @ManyToMany(mappedBy = "peliculas")
    List<Actor> actor;


    public Pelicula()
    {
        actor = new ArrayList<Actor>();
    }

    public int getFilmId() {
        return filmId;
    }

    public void setFilmId(int filmId) {
        this.filmId = filmId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getRelease_year() {
        return release_year;
    }

    public void setRelease_year(int release_year) {
        this.release_year = release_year;
    }

    public Timestamp getLastUpdate() {
        return lastUpdate;
    }

    public void setLastUpdate(Timestamp lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

}
