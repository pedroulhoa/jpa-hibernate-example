package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.DAO;

import static org.junit.jupiter.api.Assertions.*;

class OrderTest {

    DAO<Order> dao;

    @BeforeEach
    void dao() {
        dao = new DAO<>(Order.class);
    }

    @Test
    void getOrderItemsByOrder() {
        Order order = dao.getByID(29L);
        order.getItems().forEach(orderItem -> {
            System.out.println(orderItem.getQuantity());
            System.out.println(orderItem.getProduct().getName());
        });

        assertNotNull(order);
        dao.closeEntityManager();
    }

}