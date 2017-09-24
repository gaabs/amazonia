package models.collections;

import models.entities.Product;
import models.repositories.ProductRepository;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

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

    public Set<Product> find(String name, String category) {
        return productRepository
                .findAll()
                .stream()
                .filter(product -> name == null || product.name.toLowerCase().contains(name.toLowerCase()))
                .filter(product -> category == null || product.category.equalsIgnoreCase(category))
                .collect(Collectors.toCollection(HashSet::new));
    }

    public Product findById(Integer id) {
        return productRepository.findById(id);
    }

    public boolean create(Product product) {
        return productRepository.create(product);
    }

    public boolean update(Product product) {
        return productRepository.update(product);
    }
}
