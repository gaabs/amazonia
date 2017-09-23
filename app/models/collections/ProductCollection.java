package models.collections;

import models.entities.Product;
import models.repositories.ProductRepository;

import java.util.Set;

public class ProductCollection {
    private ProductRepository productRepository;

    public ProductCollection(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public void decrementQuantity(Product product) {
        if (product.quantity == 0) {
            // TODO: throw error
        }

        product.quantity--;
        productRepository.update(product);
    }

    public void incrementQuantity(Product product) {
        product.quantity++;
        productRepository.update(product);
    }


    public Set<Product> findAll() {
        return productRepository.findAll();
    }

    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    public boolean create(Product product) {
        return productRepository.create(product);
    }
}
