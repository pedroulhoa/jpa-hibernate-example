package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class PersistenceUtil {

    private static EntityManagerFactory emf;

    private static EntityManagerFactory getEntityManagerFactor() {
        if (emf == null) createEntityManagerFactor();

        return emf;
    }

    private static void createEntityManagerFactor() {
        emf = Persistence.createEntityManagerFactory("exampledb");
    }

    public static EntityManager getEntityManager() {
        return PersistenceUtil.getEntityManagerFactor().createEntityManager();
    }
}
