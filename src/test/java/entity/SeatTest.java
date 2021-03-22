package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.DAO;

import static org.junit.jupiter.api.Assertions.*;

class SeatTest {

    DAO<Seat> dao;

    @BeforeEach
    void dao() {
        dao = new DAO<>(Seat.class);
    }

    @Test
    void getClientBySeat() {
        Seat seat = dao.getByID(14L);
        System.out.println(seat.getClient().getName());
        assertNotNull(seat.getId());
    }

}