package com.goodreads.app.controllers;

import com.goodreads.app.models.UserEntity;
import com.goodreads.app.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    //List all users
    @GetMapping("/all")
    public ResponseEntity<Iterable<UserEntity>> getAllUsers(){
        Iterable<UserEntity> users =  userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Find employee by id
    @GetMapping("/find/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id) {
        UserEntity user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Adding user by id
    @PostMapping("/add")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user){
        UserEntity newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    //Update user
    @PutMapping("/update")
    public ResponseEntity<UserEntity> updateUser(@RequestBody UserEntity user){
        UserEntity updateUser = userService.updateUser(user);
        return new ResponseEntity<>(updateUser, HttpStatus.OK);
    }

    //Delete user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
