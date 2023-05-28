package com.goodreads.app.repositories;

import com.goodreads.app.models.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends CrudRepository<User, Long> {
    public void deleteUserById(Long id);
    public Optional<User> findUserById(Long id);
}
