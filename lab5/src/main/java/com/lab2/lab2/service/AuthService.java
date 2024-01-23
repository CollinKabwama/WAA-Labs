package com.lab2.lab2.service;

import com.lab2.lab2.entity.dto.request.LoginRequest;
import com.lab2.lab2.entity.dto.request.RefreshTokenRequest;
import com.lab2.lab2.entity.dto.response.LoginResponse;

public interface AuthService {
    LoginResponse login(LoginRequest loginRequest);
    LoginResponse refreshToken(RefreshTokenRequest refreshTokenRequest);
}