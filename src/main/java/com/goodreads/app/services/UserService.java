package com.goodreads.app.services;

import com.goodreads.app.exception.UserNotFoundException;
import com.goodreads.app.models.User;
import com.goodreads.app.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Adding new user to database, vaata Spring Security registreerimise osa
    public User addUser(User user) {
        return userRepository.save(user);
    }

    //Finding all users
    public Iterable<User> findAllUsers() {
        return userRepository.findAll();
    }

    //Update user
    public User updateUser(User user){
        return userRepository.save(user);
    }

    //Find user by id
    public User findUserById(Long id){
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    //Delete employee
    public void deleteUser(Long id){
        userRepository.deleteUserById(id);
    }

}
