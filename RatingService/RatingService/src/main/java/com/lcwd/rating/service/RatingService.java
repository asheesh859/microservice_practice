package com.lcwd.rating.service;


import com.lcwd.rating.entity.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating createRating(Rating rating);
    //get all rating

    List<Rating> getAllRating();

    //get all by userId
    List<Rating> getRatingByUserId(String userId);

    //get all by hotelId
    List<Rating> getRatingByHotelId(String hotelId);
}
