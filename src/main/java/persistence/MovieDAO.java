package persistence;

import entity.Movie;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import java.util.List;
import java.util.Optional;

public class MovieDAO extends DAO<Movie> {

    public MovieDAO() {
        super(Movie.class);
    }

    public Optional<List<Movie>> getMoviesByHigherRate(Double rate) {
        EntityManager em = PersistenceUtil.getEntityManager();
        List<Movie> movies = null;

        String sql = "select distinct m from Movie m " +
                "join fetch m.actors " +
                "where m.rate > :rate";

        try {
            TypedQuery<Movie> query = em.createQuery(sql, Movie.class);
            query.setParameter("rate", rate);
            movies = query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            em.close();
        }

        return Optional.ofNullable(movies);
    }
}
