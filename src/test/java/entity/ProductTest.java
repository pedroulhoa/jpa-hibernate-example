package entity;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import persistence.ProductDAO;

import java.util.List;

class ProductTest {

    ProductDAO dao;

    @BeforeEach
    void dao() {
        dao = new ProductDAO();
    }

    @Test
    void createProductTest() {
        Product product = new Product("Iphone", 3900.20);
        dao.insertAtomic(product).closeEntityManager();
        Assertions.assertNotNull(product.getId());
    }

    @Test
    void getAllProductsTest() {
        List<Product> products = dao.getAll();
        products.forEach(System.out::println);
        dao.closeEntityManager();
        Assertions.assertNotNull(products);
    }

    @Test
    void calculateTotalPriceProductsTest() {
        List<Product> products = dao.getAll();

        double totalPrice = products
                .stream()
                .map(Product::getPrice)
                .reduce(0.0, Double::sum);

        System.out.println("Total calculate: " + totalPrice);
        Assertions.assertTrue(totalPrice > 0);
    }


}