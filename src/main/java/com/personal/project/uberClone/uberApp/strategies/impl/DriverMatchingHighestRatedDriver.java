package com.personal.project.uberClone.uberApp.strategies.impl;

import com.personal.project.uberClone.uberApp.dto.RideRequestDto;
import com.personal.project.uberClone.uberApp.entities.Driver;
import com.personal.project.uberClone.uberApp.entities.RideRequest;
import com.personal.project.uberClone.uberApp.repositories.DriverRepository;
import com.personal.project.uberClone.uberApp.strategies.DriverMatchingStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional()
public class DriverMatchingHighestRatedDriver implements DriverMatchingStrategy {

    private final DriverRepository driverRepository;

    @Override
    public List<Driver> findMatchingDriver(RideRequest rideRequest) {
        return driverRepository.findTenNearbyTopRatedDrivers(rideRequest.getPickupLocation());
    }
}