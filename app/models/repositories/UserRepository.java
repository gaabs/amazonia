package models.repositories;

import models.entities.User;

import java.util.HashSet;
import java.util.Set;

public class UserRepository {
    private Set<User> users;

    public UserRepository() {
        users = new HashSet<>();
    }

    public Set<User> findAll() {
        return new HashSet<>(users);
    }

    public Set<User> findByName(String term) {
        final Set<User> results = new HashSet<User>();
        for (User user : users) {
            if (user.name.toLowerCase().contains(term.toLowerCase())) {
                results.add(user);
            }
        }
        return results;
    }

    public boolean create(User user) {
        return users.add(user);
    }

    public boolean delete(User user) {
        return users.remove(user);
    }

    public boolean update(User user) {
        User oldUser = findByEmail(user.email);
        if (oldUser == null) {
            return false;
        }

        oldUser.name = user.name;
        oldUser.password = user.password;

        return true;
    }

    public User findByEmail(String email) {
        return users.stream()
                .filter(user -> user.email.equalsIgnoreCase(email))
                .findFirst()
                .orElse(null);
    }
}
