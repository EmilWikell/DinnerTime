package com.example.dinnertime.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.NoArgsConstructor;

@Entity
public class Review {
    @Id
    private long id;
    private String username;
    private String nameRestaurant;
    private String apiId;
    private String photoUrl;
    private long rating;
    private String comment;


    public Review() {
    }

    public Review(long id, String username, String nameRestaurant, String apiId, String photoUrl, long rating, String comment ) {
        this.id = id;
        this.username = username;
        this.nameRestaurant = nameRestaurant;
        this.apiId = apiId;
        this.photoUrl = photoUrl;
        this.rating = rating;
        this.comment = comment;
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
