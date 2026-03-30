package com.personal.project.uberClone.uberApp.services;

import com.personal.project.uberClone.uberApp.dto.DriverDto;
import com.personal.project.uberClone.uberApp.dto.SignupDto;
import com.personal.project.uberClone.uberApp.dto.UserDto;

public interface AuthService {
    String login(String email, String password);

    UserDto signup(SignupDto signupDto);

    DriverDto onboardNewDriver(String userId);
}
