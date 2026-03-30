package com.personal.project.uberClone.uberApp.controllers;

import com.personal.project.uberClone.uberApp.dto.SignupDto;
import com.personal.project.uberClone.uberApp.dto.UserDto;
import com.personal.project.uberClone.uberApp.services.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;

    @PostMapping("/signup")
    UserDto signUp(@RequestBody SignupDto signupDto) {
        return authService.signup(signupDto);
    }

}
