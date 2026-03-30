package com.personal.project.uberClone.uberApp.services;

import com.personal.project.uberClone.uberApp.dto.DriverDto;
import com.personal.project.uberClone.uberApp.dto.RideDto;
import com.personal.project.uberClone.uberApp.dto.RideRequestDto;
import com.personal.project.uberClone.uberApp.dto.RiderDto;
import com.personal.project.uberClone.uberApp.entities.RideRequest;
import com.personal.project.uberClone.uberApp.entities.Rider;
import com.personal.project.uberClone.uberApp.entities.User;

import java.util.List;

public interface RiderService {
    RideRequestDto requestRide(RideRequestDto rideRequestDto);

    RideDto cancelRide(Long rideId);

    DriverDto rateDriver(Long rideId, Integer rating);

    RiderDto getMyProfile();

    List<RideDto> getAllMyRides();

    Rider createNewRider(User user);
}
