package entity;

import entity.embeddableEntities.Address;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.DAO;

import static org.junit.jupiter.api.Assertions.*;

class ProviderTest {

    DAO<Provider> dao;

    @BeforeEach
    void dao() {
        dao = new DAO<>(Provider.class);
    }

    @Test
    void createProviderTest() {
        Address address = new Address("Brasília", "Taguatinga");
        Provider provider = new Provider("The Fruits", address);
        dao.insertAtomic(provider).closeEntityManager();

        assertNotNull(provider.getId());
    }

}