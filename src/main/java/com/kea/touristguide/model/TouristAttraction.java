package com.kea.touristguide.model;

import java.util.ArrayList;
import java.util.List;

public class TouristAttraction {
    private String name;
    private String description;
    private String image;
    private int priceDkk;
    private String city;
    private List<String> tags = new ArrayList<>();

    // Constructor with parameters ...
    public TouristAttraction(String name, String description, String image, int priceDkk, String city, List<String> tags) {
        this.name = name;
        this.description = description;
        this.image = image;
        this.priceDkk = priceDkk;
        this.city = city;
        this.tags = tags;
    }

    // Getters and setters to access private variables (to avoid Jackson 2 500 server error) ...
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public String getDescription() {
        return description;
    }
    public void setDescription(String description) {
        this.description = description;
    }
    public String getImage() {
        return image;
    }
    public void setImage(String image) {
        this.image = image;
    }
    public int getPriceDkk() {
        return priceDkk;
    }
    public void setPriceDkk(int priceDkk) {
        this.priceDkk = priceDkk;
    }
    public String getCity() {
        return city;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public List<String> getTags() {
        return tags;
    }
    public void setTags(List<String> tags) {
        this.tags = tags;
    }
}
