package com.personal.project.uberClone.uberApp.strategies;

import com.personal.project.uberClone.uberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLIER = 10;

    double calculateFare(RideRequest rideRequest);
}
