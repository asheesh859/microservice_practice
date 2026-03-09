package com.lcwd.user.service.service.impl;

import com.lcwd.user.service.entity.Hotel;
import com.lcwd.user.service.entity.Rating;
import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.external.service.HotelService;
import com.lcwd.user.service.repository.UserRepository;
import com.lcwd.user.service.service.UserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private HotelService hotelService;


    Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);

    @Override
    public User saveUser(User user) {

        //generate unique ID
        String rendomUserId = UUID.randomUUID().toString();
        user.setUserID(rendomUserId);
        return userRepository.save(user);
    }

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }


    //get user by Id
    @Override
    public User getUserById(String userId) {
        User user = userRepository.findById(userId)
                .orElseThrow(()->new RuntimeException("user not found of given ID" + userId));

      //fetch ratting from ratting service
        // http://localhost:8083/ratings/users/2dd396a5-85f0-4be4-86c5-150998a96bad

        Rating[] ratingOfUser =  restTemplate.getForObject("http://RATING-SERVICE/ratings/users/"+user.getUserID(),Rating[].class);
       logger.info("{} ",ratingOfUser);

        List<Rating> ratings = Arrays.stream(ratingOfUser).toList();

        List<Rating> listOfRating = ratings.stream().map(rating ->{

           // ResponseEntity<Hotel> hotel = restTemplate.getForEntity("http://HOTEL-SERVICE/hotels/"+rating.getHotelId(), Hotel.class);

            Hotel hotel = hotelService.getHotel(rating.getHotelId());
                rating.setHotel(hotel);
               return rating;
        }).collect(Collectors.toList());
         user.setRating(listOfRating);
            return user;
    }
}
