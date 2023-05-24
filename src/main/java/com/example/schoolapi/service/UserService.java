package com.example.schoolapi.service;

import java.util.List;

import com.example.schoolapi.dto.LoginRequest;
import com.example.schoolapi.dto.UserDto;
import com.example.schoolapi.model.User;

public interface UserService {
    UserDto signup(UserDto user);

    UserDto login(LoginRequest loginDto);

    UserDto findUserByEmail(String email);

    List<User> getAllUser();
}
