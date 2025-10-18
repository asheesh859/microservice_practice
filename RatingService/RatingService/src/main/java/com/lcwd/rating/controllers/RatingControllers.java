package com.lcwd.rating.controllers;

import com.lcwd.rating.entity.Rating;
import com.lcwd.rating.service.impl.RatingImplService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/ratings")
public class RatingControllers {

    @Autowired
    private RatingImplService service;

    @PostMapping
    public ResponseEntity<Rating> createRating(@RequestBody Rating rating) {
        Rating createRating = service.createRating(rating);
        return ResponseEntity.status(HttpStatus.CREATED).body(createRating);
    }

    @GetMapping
    public ResponseEntity<List<Rating>> getRating() {
        List<Rating> ratings = service.getAllRating();
        return ResponseEntity.ok(ratings);

    }

    @GetMapping("/users/{userId}")
    public ResponseEntity<List<Rating>> getRatingByUserId(@PathVariable String userId) {
        List<Rating> ratingByUserId = service.getRatingByUserId(userId);
        System.out.println(ratingByUserId);
        return ResponseEntity.ok(ratingByUserId);
    }

    @GetMapping("/hotels/{hotelId}")
    public ResponseEntity<List<Rating>> getRatingByHotelId(@PathVariable String hotelId){
        List<Rating> ratingByHotelId = service.getRatingByHotelId(hotelId);
        return ResponseEntity.ok(ratingByHotelId);
    }
}