package entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "tb_movie")
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private Double rate;

    @ManyToMany(cascade = CascadeType.PERSIST)
    @JoinTable(
            name = "tb_movie_actor",
            joinColumns = @JoinColumn(name = "movie_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "actor_id", referencedColumnName = "id")
    )
    private List<Actor> actors;

    public Movie() {
    }

    public Movie(String name, Double rate) {
        this.name = name;
        this.rate = rate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getRate() {
        return rate;
    }

    public void setRate(Double rate) {
        this.rate = rate;
    }

    public List<Actor> getActors() {
        if (actors == null) actors = new ArrayList<>();
        return actors;
    }

    public void setActors(List<Actor> actors) {
        this.actors = actors;
    }

    @Override
    public String toString() {
        return "Movie{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", rate=" + rate +
                ", actors=" + actors +
                '}';
    }

    public void addActor(Actor actor) {
        if (actor != null && !getActors().contains(actor)) {
            getActors().add(actor);
            if (!actor.getMovies().contains(this)) actor.getMovies().add(this);
        }
    }
}
