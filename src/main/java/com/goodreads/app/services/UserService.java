package com.goodreads.app.services;

import com.goodreads.app.exception.UserNotFoundException;
import com.goodreads.app.models.UserEntity;
import com.goodreads.app.repositories.UserRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UserService {
    private final UserRepository userRepository;
    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    //Adding new user to database
    public UserEntity addUser(UserEntity user) {
        return userRepository.save(user);
    }

    //Finding all users
    public Iterable<UserEntity> findAllUsers() {
        return userRepository.findAll();
    }

    //Update user
    public UserEntity updateUser(UserEntity user){
        return userRepository.save(user);
    }

    //Find user by id
    public UserEntity findUserById(Long id){
        return userRepository.findUserById(id).orElseThrow(() -> new UserNotFoundException("User by id " + id + " was not found"));
    }

    //Delete employee
    public void deleteUser(Long id){
        userRepository.deleteUserById(id);
    }

}
