package com.lwcd.hotel.Hotel.repositories;

import com.lwcd.hotel.Hotel.entity.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel , String> {

}
