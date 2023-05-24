package com.example.schoolapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.schoolapi.model.User;

public interface UserRepository extends CrudRepository<User, Long> {

    Optional<User> findByEmail(String email);
}
