package models.entities;

public class User {

    public Integer id;
    public String name;
    public String password;

    public User() {
    }

    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
    }

    public String toString() {
        return String.format("%s - %s", id, name);
    }

}
