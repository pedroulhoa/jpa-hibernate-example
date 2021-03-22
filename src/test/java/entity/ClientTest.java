package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.DAO;

import static org.junit.jupiter.api.Assertions.*;

class ClientTest {

    DAO<Object> dao;

    @BeforeEach
    void dao() {
        dao = new DAO<>(Object.class);
    }

    @Test
    void insertClientAndSeatTest() {
        Seat seat = new Seat("3E");
        Client client = new Client("Maria", seat);

        dao.openTransaction()
                .insert(seat)
                .insert(client)
                .closeTransaction()
                .closeEntityManager();

        assertNotNull(seat.getId());
        assertNotNull(client.getId());
    }

    @Test
    void insertClientAndSeatCascadeTest() {
        Seat seat = new Seat("5B");
        Client client = new Client("Lucas", seat);

        dao.openTransaction()
                .insert(client)
                .closeTransaction()
                .closeEntityManager();

        assertNotNull(seat.getId());
        assertNotNull(client.getId());
    }

}