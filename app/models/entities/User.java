package models.entities;

public class User {

    public Integer id;
    public String name;
    public String password;
    public Integer numberOfPuchases;

    public User() {
    }

    public User(Integer id, String name, String password) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.numberOfPuchases = 0;
    }

    public String getName(){
        return this.name;
    }

    public void addPuchase(){
        this.numberOfPuchases++;
    }

    public String toString() {
        return String.format("%s - %s", id, name);
    }

}
