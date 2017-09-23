package models.repositories;

import models.entities.Product;

import java.util.HashSet;
import java.util.Set;

public class ProductRepository {
    private Set<Product> products;

    public ProductRepository() {
        products = new HashSet<>();
    }

    public Set<Product> findAll() {
        return new HashSet<>(products);
    }

    public Product findById(Integer id) {
        for (Product product : products) {
            if (product.id.equals(id)) {
                return product;
            }
        }
        return null;
    }

    public Set<Product> findByName(String term) {
        final Set<Product> results = new HashSet<Product>();
        for (Product product : products) {
            if (product.name.toLowerCase().contains(term.toLowerCase())) {
                results.add(product);
            }
        }
        return results;
    }


    public boolean create(Product product) {
        return products.add(product);
    }

    public boolean delete(Product product) {
        return products.remove(product);
    }

    public boolean update(Product product) {
        Product oldProduct = findById(product.id);
        if (oldProduct == null) {
            return false;
        }

        oldProduct.name = product.name;
        oldProduct.description = product.description;
        oldProduct.price = product.price;
        oldProduct.quantity = product.quantity;

        return true;
    }
}
