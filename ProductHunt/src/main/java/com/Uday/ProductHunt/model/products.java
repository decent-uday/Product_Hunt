package com.Uday.ProductHunt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "products")
public class products {
    public String get_id() {
        return _id;
    }

    public void set_id(String _id) {
        this._id = _id;
    }

    @Id
    private String _id;

    private double stars;

    private String productName;
    private int reviews;
    private String description;
    private String category;
    private String launchDate;
    private String website;

    public products(String productName, int reviews, String description, String category, String launchDate, String website) {
        this.productName = productName;
        this.reviews = reviews;
        this.description = description;
        this.category = category;
        this.launchDate = launchDate;
        this.website = website;
    }

    @Override
    public String toString() {
        return "Product{" +
                "id='" + _id + '\'' +
                ", productName='" + productName + '\'' +
                ", reviews=" + reviews +
                ", description='" + description + '\'' +
                ", category='" + category + '\'' +
                ", launchDate='" + launchDate + '\'' +
                ", website='" + website + '\'' +
                '}';
    }


    public void setStars(double Stars) {
        this.stars = Stars;
    }

    public double getStars() {
        return stars;
    }


    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public int getReviews() {
        return reviews;
    }

    public void setReviews(int reviews) {
        this.reviews = reviews;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getLaunchDate() {
        return launchDate;
    }

    public void setLaunchDate(String launchDate) {
        this.launchDate = launchDate;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }
}

