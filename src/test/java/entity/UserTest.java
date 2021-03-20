package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.Objects;

public class UserTest {

    EntityManagerFactory emf;
    EntityManager em;

    @BeforeEach
    void db() {
        emf = Persistence.createEntityManagerFactory("exampledb");
        em = emf.createEntityManager();
    }

    @Test
    void createUserTest() {
        User user = new User("Paulo", "user@mail.com");

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        em.close();
        emf.close();

        System.out.println(user.getId());
        Assertions.assertTrue(user.getId() != null);
    }

    @Test
    void findUserTest() {
        User user = em.find(User.class, 1L);
        System.out.println(user);
        Assertions.assertTrue(Objects.nonNull(user));
    }

}