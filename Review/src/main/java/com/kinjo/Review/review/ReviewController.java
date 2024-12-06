package com.kinjo.Review.review;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/reviews")
public class ReviewController {
    private final ReviewService reviewService;

    public ReviewController(ReviewService reviewService) {
        this.reviewService = reviewService;
    }

    //  To get reviews
    @GetMapping
    public ResponseEntity<List<Review>> getAllReviews(@RequestParam Long companyId){
        return new ResponseEntity<>(reviewService.getAllReviews(companyId), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<String> addReview(@RequestParam Long companyId, @RequestBody Review reviews){
        boolean isReviewSaves = reviewService.addReview(companyId, reviews);
        if(isReviewSaves) {
            return new ResponseEntity<>("Review added successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review not add", HttpStatus.NOT_FOUND);
        }
    }
    @GetMapping("/{reviewId}")
    public ResponseEntity<Review> getReview(@PathVariable Long reviewId){
        return new ResponseEntity<>(reviewService.getReview(reviewId),HttpStatus.OK);
    }

    @PutMapping("/{reviewId}")
    public ResponseEntity<String> updateReiview(@PathVariable Long reviewId,
                                                @RequestBody Review review){
        boolean isRevieUpdated = reviewService.updateReview(reviewId, review);
        if(isRevieUpdated) {
            return new ResponseEntity<>("Review update successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review not updated",HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{reviewId}")
    public ResponseEntity<String> deleteReview(@PathVariable Long reviewId){
        boolean isReviewDeleted = reviewService.deleteReview( reviewId);
        if(isReviewDeleted) {
            return new ResponseEntity<>("Review update successfully", HttpStatus.OK);
        }else{
            return new ResponseEntity<>("Review not updated",HttpStatus.NOT_FOUND);
        }
    }
}
