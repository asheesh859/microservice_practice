package com.lwcd.hotel.Hotel.services;

import com.lwcd.hotel.Hotel.entity.Hotel;

import java.util.List;

public interface HotelService {
    //create

    Hotel create(Hotel hotel);
    //get all
    List<Hotel> getAll();

    //get single
    Hotel get(String id);
}
