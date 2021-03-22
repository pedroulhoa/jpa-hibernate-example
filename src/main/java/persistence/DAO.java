package persistence;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;
import java.util.List;

public class DAO<E> {

    private static EntityManagerFactory emf;
    private final EntityManager em;
    private final Class<E> sentClass;

    static {
        try {
            emf = Persistence.createEntityManagerFactory("exampledb");
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    public DAO() {
        this(null);
    }

    public DAO(Class<E> sentClass) {
        this.sentClass = sentClass;
        em = emf.createEntityManager();
    }

    public DAO<E> openTransaction() {
        em.getTransaction().begin();
        return this;
    }

    public DAO<E> closeTransaction() {
        em.getTransaction().commit();
        return this;
    }

    public void closeEntityManager() {
        em.close();
    }

    public DAO<E> insert(E entity) {
        em.persist(entity);
        return this;
    }

    public E getByID(Long id) {
        return em.find(sentClass, id);
    }

    public DAO<E> insertAtomic(E entity) {
        return this.openTransaction().insert(entity).closeTransaction();
    }

    public List<E> getAll() {
        if (sentClass == null) throw new UnsupportedOperationException("class null");
        String sql = "select e from " + sentClass.getName() + " e";
        TypedQuery<E> query = em.createQuery(sql, sentClass);
        return query.getResultList();
    }

    public List<E> getAll(int quantity, int offset) {
        if (sentClass == null) throw new UnsupportedOperationException("class null");

        String sql = "select e from " + sentClass.getName() + " e";
        TypedQuery<E> query = em.createQuery(sql, sentClass);
        query.setMaxResults(quantity);
        query.setFirstResult(offset);
        return query.getResultList();
    }

}
