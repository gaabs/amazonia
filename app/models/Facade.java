package models;

import models.collections.ProductCollection;
import models.collections.UserCollection;
import models.controls.ProductControl;
import models.controls.UserControl;
import models.entities.Product;
import models.entities.User;
import models.repositories.ProductRepository;
import models.repositories.UserRepository;

import java.util.Set;

public class Facade {
    private static Facade instance;
    private UserControl userControl;
    private ProductControl productControl;

    private Facade() {
        UserRepository userRepository = new UserRepository();
        UserCollection userCollection = new UserCollection(userRepository);
        userControl = new UserControl(userCollection);

        ProductRepository productRepository = new ProductRepository();
        ProductCollection productCollection = new ProductCollection(productRepository);
        productControl = new ProductControl(productCollection);
    }

    public static Facade getInstance() {
        if (instance == null) {
            instance = new Facade();
        }
        return instance;
    }

    public Set<Product> findAllProducts() {
        return productControl.findAll();
    }

    public Product findProductById(Integer id) {
        return productControl.findById(id);
    }

    public boolean createProduct(Product product) {
        return productControl.create(product);
    }

    public Set<Product> findProducts(String name, String category) {
        return productControl.find(name, category);
    }

    public Set<User> userList() {
        return userControl.list();
    }

    public User findUserById(Integer id) {
        return userControl.findById(id);
    }

    public boolean createUser(User user) {
        return userControl.create(user);
    }

}
