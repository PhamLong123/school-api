package com.example.schoolapi.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.example.schoolapi.model.RefreshToken;

public interface RefreshTokenRepository extends CrudRepository<RefreshToken, Long> {
    Optional<RefreshToken> findByToken(String token);
}
