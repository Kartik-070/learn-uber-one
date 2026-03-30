package com.personal.project.uberClone.uberApp.services;

import com.personal.project.uberClone.uberApp.dto.RideRequestDto;
import com.personal.project.uberClone.uberApp.entities.Driver;
import com.personal.project.uberClone.uberApp.entities.Ride;
import com.personal.project.uberClone.uberApp.entities.enums.RideStatus;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;

public interface RideService {

    Ride getRideById(Long rideId);

    void matchWithDrivers(RideRequestDto rideRequestDto);

    Ride createNewRide(RideRequestDto rideRequestDto, Driver driver);

    Ride updateRideStatus(Long rideId, RideStatus rideStatus);

    Page<Ride> getAllRidesOfRider(Long riderId, PageRequest pageRequest);

    Page<Ride> getAllRidesOfDriver(Long driverId, PageRequest pageRequest);

}
 