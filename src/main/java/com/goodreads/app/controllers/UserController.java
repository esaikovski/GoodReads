package com.goodreads.app.controllers;

import com.goodreads.app.dto.PartialUpdateRequestDto;
import com.goodreads.app.models.UserEntity;
import com.goodreads.app.repositories.UserRepository;
import com.goodreads.app.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/user")
public class UserController {
    private final UserService userService;
    private final PasswordEncoder passwordEncoder;

    public UserController(UserService userService, PasswordEncoder passwordEncoder) {
        this.userService = userService;
        this.passwordEncoder = passwordEncoder;
    }

    //List of all users
    @GetMapping("/all")
    public ResponseEntity<Iterable<UserEntity>> getAllUsers(){
        Iterable<UserEntity> users =  userService.findAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    //Find a user by id
    @GetMapping("/find/{id}")
    public ResponseEntity<UserEntity> getUserById(@PathVariable("id") Long id) {
        UserEntity user = userService.findUserById(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Find a user by username
    @GetMapping("/find/username/{username}")
    public ResponseEntity<UserEntity> getUserByUsername(@PathVariable("username") String username) {
        UserEntity user = userService.findUserByUsername(username);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    //Add a user by id
    @PostMapping("/add")
    public ResponseEntity<UserEntity> addUser(@RequestBody UserEntity user){
        UserEntity newUser = userService.addUser(user);
        return new ResponseEntity<>(newUser,HttpStatus.CREATED);
    }

    //Update an existing user
    @PatchMapping("/update/{id}")
    public ResponseEntity<?> updateUser(@PathVariable Long id, @RequestBody PartialUpdateRequestDto request) {
        UserEntity existingUser  = userService.findUserById(id);

        if (existingUser == null) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        // Update specific fields if they are provided in the request
        if (request.getUsername() != null) {
            existingUser.setUsername(request.getUsername());
        }

        if (request.getPassword() != null) {
            String encodedPassword = passwordEncoder.encode(request.getPassword());
            existingUser.setPassword(encodedPassword);
        }

        if (request.getFullName() != null) {
            existingUser.setFullName(request.getFullName());
        }

        if (request.getEmail() != null) {
            existingUser.setEmail(request.getEmail());
        }

        if (request.getGender() != null) {
            existingUser.setGender(request.getGender());
        }

        if (request.getAddress() != null) {
            existingUser.setAddress(request.getAddress());
        }

        if (request.getAboutMe() != null) {
            existingUser.setAboutMe(request.getAboutMe());
        }

        // Update other fields as needed

        UserEntity updatedUser = userService.updateUser(existingUser);

        return new ResponseEntity<>(updatedUser, HttpStatus.OK);
    }

    //Delete an existing user
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteUser(@PathVariable("id") Long id){
        // Check if the user exists
        userService.findUserById(id);

        // Delete the user's dependencies first to avoid constraint violations
        userService.deleteUserDependencies(id);

        userService.deleteUser(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
