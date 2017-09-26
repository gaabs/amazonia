package models.controls;

import models.collections.UserCollection;
import models.entities.User;
import models.services.LoginService;

import java.util.Set;

public class UserControl {
    private UserCollection userCollection;

    public UserControl(UserCollection userCollection) {
        this.userCollection = userCollection;
    }

    public Set<User> list() {
        return userCollection.list();
    }

    public User findByEmail(String email) {
        return userCollection.findByEmail(email);
    }

    public boolean create(User user) {
        return userCollection.register(user);
    }

    public boolean login(String email, String password) {
        User user = userCollection.findByEmail(email);

        if (user == null || !correctPassword(user, password)) {
            return false;
        }

        return LoginService.getInstance().login(user);
    }

    private boolean correctPassword(User user, String password) {
        return user.password.equalsIgnoreCase(password);
    }
}
