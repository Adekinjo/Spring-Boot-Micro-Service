package com.kinjo.Review.review;

import java.util.List;

public interface ReviewService {

    // getting reviews
    List<Review> getAllReviews(Long CompanyId);

    // to add reviews
    boolean addReview(Long companyId, Review reviews);

    Review getReview(Long reviewId);

    boolean updateReview(Long reviewId,Review review);

    boolean deleteReview(Long reviewId);
}
