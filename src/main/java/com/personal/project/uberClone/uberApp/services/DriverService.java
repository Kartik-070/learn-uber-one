package com.personal.project.uberClone.uberApp.services;

import com.personal.project.uberClone.uberApp.dto.DriverDto;
import com.personal.project.uberClone.uberApp.dto.RideDto;
import com.personal.project.uberClone.uberApp.dto.RiderDto;

import java.util.List;

public interface DriverService {
    RideDto acceptRide(Long rideId);

    RideDto cancelRide(Long rideId);

    RideDto startRide(Long rideId);

    RideDto endRide(Long rideId);

    RiderDto rateRider(Long rideId, Integer rating);

    DriverDto getMyProfile();

    List<RideDto> getAllMyRides();

}
