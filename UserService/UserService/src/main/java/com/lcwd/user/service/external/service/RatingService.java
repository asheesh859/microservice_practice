package com.lcwd.user.service.external.service;


import com.lcwd.user.service.entity.Rating;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.*;

@FeignClient("RATING-SERVICE")
public interface RatingService {
    //get
        @GetMapping("/ratings")
        public Rating getAllRating();
    //post
        @PostMapping("/ratings")
        public Rating createRating(Rating rating);
    //put

        @PutMapping("/ratings/{ratingId}")
        public Rating updateRating(@PathVariable("ratingId") String ratingId, Rating ratings);

        //delete

        @DeleteMapping("/ratings/{ratingId}")
        public String deleteRatingById(@PathVariable("ratingId") String ratingId);
}
