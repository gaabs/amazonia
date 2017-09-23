package models.controls;

import models.collections.UserCollection;
import models.entities.User;

import java.util.Set;

public class UserControl {
    private UserCollection userCollection;

    public UserControl(UserCollection userCollection) {
        this.userCollection = userCollection;
    }

    public Set<User> list() {
        return userCollection.list();
    }

    public User findById(Integer id) {
        return userCollection.findById(id);
    }

    public boolean create(User user) {
        return userCollection.register(user);
    }
}
