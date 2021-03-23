package entity;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.DAO;

import static org.junit.jupiter.api.Assertions.*;

class OrderItemTest {

    DAO<Object> dao;

    @BeforeEach
    void dao() {
        dao = new DAO<>();
    }

    @Test
    void insertOrderItemTest() {
        Order order = new Order();
        Product product = new Product("IPhone", 4506.90);
        OrderItem orderItem = new OrderItem(order, product, 4);

        dao.openTransaction()
                .insert(order)
                .insert(product)
                .insert(orderItem)
                .closeTransaction()
                .closeEntityManager();

        assertNotNull(orderItem.getId());
    }

}