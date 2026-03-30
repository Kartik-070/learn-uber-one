package com.personal.project.uberClone.uberApp.strategies.impl;

import com.personal.project.uberClone.uberApp.dto.RideRequestDto;
import com.personal.project.uberClone.uberApp.entities.RideRequest;
import com.personal.project.uberClone.uberApp.strategies.RideFareCalculationStrategy;

public class RideFareSurgeicingFareCalculation implements RideFareCalculationStrategy {
    @Override
    public double calculateFare(RideRequest rideRequest) {
        return 0;
    }
}
