package models.controls;

import models.collections.ProductCollection;
import models.entities.Product;

import java.util.Set;

public class ProductControl {
    private ProductCollection productCollection;

    public ProductControl(ProductCollection productCollection) {
        this.productCollection = productCollection;
    }

    public Set<Product> findAll(){
        return productCollection.findAll();
    }

    public Product findById(Integer id) {
        return productCollection.findById(id);
    }

    public boolean create(Product product) {
        return productCollection.create(product);
    }
}
