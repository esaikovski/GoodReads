package com.goodreads.app.repositories;

import com.goodreads.app.models.Role;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface RoleRepository extends CrudRepository<Role, Long> {

    // Find role by its name
    Optional<Role> findByName(String name);
}
