package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.DAO;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    DAO<Movie> dao;

    @BeforeEach
    void dao() {
        dao = new DAO<>();
    }

    @Test
    void createMovieActorsTest() {
        Movie movieA = new Movie("Saving Private Ryan", 8.9);
        Movie movieB = new Movie("The Fast and the Furious", 8.1);

        Actor actor1 = new Actor("Tom Hanks");
        Actor actor2 = new Actor("Vin Diesel");

        movieA.addActor(actor1);
        movieA.addActor(actor2);

        movieB.addActor(actor2);

        dao.insertAtomic(movieA).closeEntityManager();
        assertNotNull(movieA);
    }

}