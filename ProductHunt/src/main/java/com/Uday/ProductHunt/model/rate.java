package com.Uday.ProductHunt.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "rate")
public class rate {
    @Id
    private String _id;
    private String productName;
    private List<Rating> ratings;
    public rate() {
    }

    public rate(String productName, List<Rating> ratings) {
        this.productName = productName;
        this.ratings = ratings;
    }

    public String getId() {
        return _id;
    }

    public void setId(String id) {
        this._id = id;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public  List<Rating> getRatings() {
        return ratings;
    }

    public void setRatings(List<Rating> ratings) {
        this.ratings = ratings;
    }

    public class Rating {
        private String userId;
        private double rating;

        public String getUserId() {
            return userId;
        }

        public void setUserId(String userId) {
            this.userId = userId;
        }

        public double getRating() {
            return rating;
        }

        public void setRating(double rating) {
            this.rating = rating;
        }

        public Rating(String userId, double rating) {
            this.userId = userId;
            this.rating = rating;
        }
    }
}

