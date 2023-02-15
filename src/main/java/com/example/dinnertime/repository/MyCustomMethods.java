package com.example.dinnertime.repository;

import com.example.dinnertime.model.Review;

public interface MyCustomMethods {
    public Iterable<Review> getFriendsReviews(long id);

    public Iterable<Review> getFriendsReviewsOnRestaurant(long id, String username);
}
