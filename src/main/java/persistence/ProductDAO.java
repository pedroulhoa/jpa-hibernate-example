package persistence;

import entity.Product;

public class ProductDAO extends DAO<Product> {

    public ProductDAO() {
        super(Product.class);
    }
}
