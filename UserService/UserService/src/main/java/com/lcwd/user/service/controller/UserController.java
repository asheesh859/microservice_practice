package com.lcwd.user.service.controller;

import com.lcwd.user.service.entity.User;
import com.lcwd.user.service.service.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private UserService userService;

        //create User
    @PostMapping
    public ResponseEntity<User> createUser(@RequestBody User user){
       User user1  = userService.saveUser(user);
       return ResponseEntity.status(HttpStatus.CREATED).body(user1);
    }

    //get user by id

    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable String userId){
        User user=  userService.getUserById(userId);
        return ResponseEntity.ok(user);

    }

    @GetMapping()
    public ResponseEntity<List<User>> getAllUser(){
       List<User> user =  userService.getAllUsers();
       return ResponseEntity.ok(user);
    }
}
