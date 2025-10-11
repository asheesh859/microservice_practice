package com.lwcd.hotel.Hotel.controller;

import com.lwcd.hotel.Hotel.entity.Hotel;
import com.lwcd.hotel.Hotel.services.impl.HotelServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelServiceImpl service;
    //create
    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){

        Hotel save_Hotel = service.create(hotel);
        return ResponseEntity.status(HttpStatus.CREATED).body(save_Hotel);
    }
    //single
    @GetMapping("/{hotelId")
    public ResponseEntity<Hotel> getHotelById(String id){
        Hotel hotel = service.get(id);
        return ResponseEntity.status(HttpStatus.OK).body(hotel);
    }
    //get all
    public ResponseEntity<List<Hotel>> getAllHotel(){
        List<Hotel> result = service.getAll();
        return ResponseEntity.status(HttpStatus.OK).body(result);
    }
}
