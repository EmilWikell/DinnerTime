package com.example.dinnertime.repository;

import com.example.dinnertime.model.Review;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

@Component
public class ReviewRepositoryQueries implements MyCustomMethods {

    @Autowired
    private JdbcTemplate jdbcTemp;
    @PersistenceContext
    private EntityManager em;

    @Override
    public Iterable<Review> getFriendsReviews(long id) {

        String sqlStmt = "select review.id,name_restaurant,api_id,photo_url,rating,comment,users.username from review \n" +
                "inner join users on user_id=users.id\n" +
                "inner join friends on friend_id=users.id \n" +
                "where friends.user_id=" + id + ";";


        sqlStmt = "select review.id,name_restaurant,api_id,photo_url,rating,comment,review.username from review order by created_at desc;"; //TODO remove when log in is implemented

        return dbQueryReviewList(sqlStmt);
    }
    @Override
    public Iterable<Review> getFriendsReviewsOnRestaurant(long id, String restaurantWebId) {

        String sqlStmt = "select review.id,name_restaurant,api_id,photo_url,rating,comment,users.username from review \n" +
                "inner join users on user_id=users.id\n" +
                "inner join friends on friend_id=users.id \n" +
                "where friends.user_id=" + id + " and review.api_id=" + restaurantWebId + ";";


        sqlStmt = "select review.id,name_restaurant,api_id,photo_url,rating,comment,review.username from review where review.api_id=" + restaurantWebId + " order by created_at desc;"; //TODO remove when log in is implemented

        return dbQueryReviewList(sqlStmt);
    }

    private Iterable<Review> dbQueryReviewList(String sqlStmt){
        return jdbcTemp.query(
                sqlStmt,
                (rs, rowNum) ->
                        new Review(
                                rs.getLong("id"),
                                rs.getString("username"),
                                rs.getString("name_restaurant"),
                                rs.getString("api_Id"),
                                rs.getString("photo_Url"),
                                rs.getLong("rating"),
                                rs.getString("comment")
                        )
        );
    }
}
