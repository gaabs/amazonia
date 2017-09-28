package models.entities;

import akka.japi.Pair;

import java.util.ArrayList;

public class ProductFilter {
    String name;
    ArrayList<Category> categories;
    Pair<Float, Float> priceRange;

    public ProductFilter(String name){
        this.name = name;
        this.categories = new ArrayList<>();
        this.priceRange = null;
    }

    public ProductFilter(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Category> getCategories() {
        return categories;
    }

    public void setCategories(ArrayList<Category> categories) {
        this.categories = categories;
    }

    public Pair<Float, Float> getPriceRange() {
        return priceRange;
    }

    public void setPriceRange(Pair<Float, Float> priceRange) {
        this.priceRange = priceRange;
    }
}