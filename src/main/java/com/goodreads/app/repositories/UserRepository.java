package com.goodreads.app.repositories;

import com.goodreads.app.models.UserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long> {
    //This allows to create specific queries without actually writing them separately

    //Delete user by a specified id
    void deleteUserById(Long id);

    //Find user by a specified id
    Optional<UserEntity> findUserById(Long id);

    //Find user by a specified id
    Optional<UserEntity> findByUsername(String username);

    //Returns true/false if such username doest exist
    Boolean existsByUsername(String username);
}
