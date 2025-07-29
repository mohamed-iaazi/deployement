package com.medo.backend.auth.repository;

import com.medo.backend.user.model.User;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface AuthRepository extends CrudRepository<User ,Long> {

    Optional<User> findUserByName(String username);
    Optional<User> findByEmail(String email);
    boolean existsByName(String name);
    boolean existsByEmail(String email);
}
