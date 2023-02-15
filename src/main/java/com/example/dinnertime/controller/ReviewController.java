package com.example.dinnertime.controller;

import com.example.dinnertime.model.Review;
import com.example.dinnertime.model.ReviewFEModel;
import com.example.dinnertime.repository.ReviewRepository;
import com.example.dinnertime.repository.ReviewRepositoryQueries;
import com.example.dinnertime.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    @Autowired
    ReviewRepositoryQueries reviewRepoQueries;
    @Autowired
    ReviewRepository reviewRepo;
    @Autowired
    UsersRepository usersRepo;


    @RequestMapping("/getAllFriendsReviews/{username}")
    public Iterable<Review> getAllFriendsReviews(@PathVariable String username ){
        long id = usersRepo.findByUsername(username).getId();
        return reviewRepoQueries.getFriendsReviews(id);
    }
    @RequestMapping("/getAllFriendsReviewsOnRestaurant/{restaurantWebId}/{username}")
    public Iterable<Review> getAllFriendsReviewsOnRestaurant(@PathVariable String restaurantWebId, @PathVariable String username){
        long id = usersRepo.findByUsername(username).getId();
        return reviewRepoQueries.getFriendsReviewsOnRestaurant(id,restaurantWebId);
    }

    @RequestMapping("/postReview")
    public String postReview(@RequestBody Review review){
        if (review.getComment() == null || review.getComment().isEmpty()){
           review.setComment("");
        }
        System.out.println(2222);
        reviewRepo.save(review);
        System.out.println(review.getNameRestaurant());
        String returnMessage = "Review on " + review.getNameRestaurant() + " posted";
        return returnMessage;
    }
}
