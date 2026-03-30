package com.personal.project.uberClone.uberApp.strategies;

import com.personal.project.uberClone.uberApp.entities.Driver;
import com.personal.project.uberClone.uberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
