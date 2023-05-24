package com.example.schoolapi.service;

import java.util.Optional;

import com.example.schoolapi.model.RefreshToken;

public interface RefreshTokenService {
    public Optional<RefreshToken> findByToken(String token);
    public RefreshToken createRefreshToken(String email);
    public RefreshToken verifyExpiration(RefreshToken token);
}
