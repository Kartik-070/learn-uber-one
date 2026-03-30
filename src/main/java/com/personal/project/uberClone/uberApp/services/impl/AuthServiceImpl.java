package com.personal.project.uberClone.uberApp.services.impl;

import com.personal.project.uberClone.uberApp.dto.DriverDto;
import com.personal.project.uberClone.uberApp.dto.SignupDto;
import com.personal.project.uberClone.uberApp.dto.UserDto;
import com.personal.project.uberClone.uberApp.entities.User;
import com.personal.project.uberClone.uberApp.entities.enums.Role;
import com.personal.project.uberClone.uberApp.exceptions.RuntimeConflictException;
import com.personal.project.uberClone.uberApp.repositories.UserRepository;
import com.personal.project.uberClone.uberApp.services.AuthService;
import com.personal.project.uberClone.uberApp.services.RiderService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Set;


@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {

    private final UserRepository userRepository;
    private final ModelMapper modelMapper;
    private final RiderService riderService;

    @Override
    public String login(String email, String password) {
        return "";
    }

    @Override
    @Transactional
    public UserDto signup(SignupDto signupDto) {
        User user = userRepository.findByEmail(signupDto.getEmail()).orElse(null);
        if(user != null)
            throw new RuntimeConflictException("Cannot signup, User already exists with email "+signupDto.getEmail());

        User mappedUser = modelMapper.map(signupDto, User.class);
        mappedUser.setRoles(Set.of(Role.RIDER));
        User savedUser = userRepository.save(mappedUser);

        riderService.createNewRider(savedUser);

        return modelMapper.map(savedUser, UserDto.class);
    }

    @Override
    public DriverDto onboardNewDriver(String userId) {
        return null;
    }
}
