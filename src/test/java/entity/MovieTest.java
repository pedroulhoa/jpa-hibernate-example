package entity;

import entity.nativeQuery.MovieRateAvg;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.MovieDAO;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class MovieTest {

    MovieDAO dao;

    @BeforeEach
    void dao() {
        dao = new MovieDAO();
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

    @Test
    void getMoviesByHigherRateTest() {
        Double rate = 5.0;
        List<Movie> movies = dao.getMoviesByHigherRate(rate).orElse(Arrays.asList());
        movies.forEach(movie -> System.out.println(movie.getName()));

        assert !movies.isEmpty();
    }

    @Test
    void getMoviesRateAvgTest() {
        MovieRateAvg movieRateAvg = dao.getMoviesRateAvg().orElse(null);
        System.out.println(movieRateAvg.getRate());
        assertNotNull(movieRateAvg);
    }


}