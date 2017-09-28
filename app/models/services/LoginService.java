package models.services;

import models.entities.User;

public class LoginService {
    private static LoginService instance;
    private User loggedUser;

    public static LoginService getInstance() {
        if (instance == null) {
            instance = new LoginService();
        }
        return instance;
    }

    public boolean login(User user) {
        loggedUser = user;
        return true;
    }

    public User getLoggedUser() {
        return loggedUser;
    }
}
