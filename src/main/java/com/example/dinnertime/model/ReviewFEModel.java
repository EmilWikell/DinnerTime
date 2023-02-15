package com.example.dinnertime.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity @NoArgsConstructor
public class ReviewFEModel {
    @Id
    private long id;
    private String nameRestaurant;
    private String apiId;
    private String photoUrl;
    private long rating;
    private String comment;
    private String username;

    public ReviewFEModel(long id, String nameRestaurant, String apiId, String photoUrl, long rating, String comment, String username) {
        this.id = id;
        this.nameRestaurant = nameRestaurant;
        this.apiId = apiId;
        this.photoUrl = photoUrl;
        this.rating = rating;
        this.comment = comment;
        this.username = username;
    }

    public String getUsername() {
        return username;
    }

    public long getId() {
        return id;
    }
    public void setComment(String comment){
        this.comment = comment;
    }
    public String getNameRestaurant() {
        return nameRestaurant;
    }

    public String getApiId() {
        return apiId;
    }

    public String getPhotoUrl() {
        return photoUrl;
    }

    public long getRating() {
        return rating;
    }

    public String getComment() {
        return comment;
    }
}
