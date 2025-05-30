package ru.yakovlev05.school.flash.service;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import ru.yakovlev05.school.flash.dto.auth.LoginRequest;
import ru.yakovlev05.school.flash.dto.auth.RegistrationRequest;

public interface AuthService {
    void registration(RegistrationRequest registrationRequest);

    void login(LoginRequest loginRequest, HttpServletResponse response);

    void logout(HttpServletRequest request);

    String refreshToken(String validatedRefreshToken, HttpServletResponse response);
}
