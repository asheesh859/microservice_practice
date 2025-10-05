package com.lcwd.user.service.service;

import com.lcwd.user.service.entity.User;

import java.util.List;

public interface UserService {

    //create

    User saveUser(User user);
    //get all user

    List<User> getAllUsers();

    // get user by ID
    User getUserById(String UserId);

    //delete

    //update

}
