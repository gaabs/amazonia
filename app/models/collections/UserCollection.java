package models.collections;

import models.entities.User;
import models.repositories.UserRepository;

import java.util.Set;

public class UserCollection {
    private UserRepository userRepository;

    public UserCollection(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean register(User user) {
        return userRepository.create(user);
    }

    public Set<User> list() {
        return userRepository.findAll();
    }

    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }
}
