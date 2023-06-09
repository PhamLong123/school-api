package com.example.schoolapi.dto;

import java.util.List;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class AccessTokenDto {
    private String token;
    private List<String> roles;
    private String refreshToken;
}
