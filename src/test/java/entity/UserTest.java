package entity;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import java.util.List;

class UserTest {

    EntityManagerFactory emf;
    EntityManager em;

    @BeforeEach
    void db() {
        emf = Persistence.createEntityManagerFactory("exampledb");
        em = emf.createEntityManager();
    }

    @AfterEach
    void close() {
        em.close();
        emf.close();
    }

    @Test
    void createUserTest() {
        User user = new User("Jorge", "user@mail.com");

        em.getTransaction().begin();
        em.persist(user);
        em.getTransaction().commit();

        System.out.println(user.getId());
        Assertions.assertNotNull(user);
    }

    @Test
    void findUserTest() {
        User user = em.find(User.class, 1L);
        System.out.println(user);
        Assertions.assertNotNull(user);
    }

    @Test
    void getAllUsersTest() {
        String sql = "select u from User u";

        List<User> users = em.createQuery(sql, User.class)
                .setMaxResults(5)
                .getResultList();

        users.forEach(System.out::println);
        Assertions.assertNotNull(users);
    }

}