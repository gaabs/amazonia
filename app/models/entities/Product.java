package models.entities;

public class Product {
    public Integer id;
    public String name;
    public String description;
    public Double price;
    public Integer quantity;
    public String category;

    public Product() {
        //
    }

    public Product(Integer id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Double getPrice() {
        return this.price;
    }

    public String toString() {
        return String.format("%s - %s", id, name);
    }

}
