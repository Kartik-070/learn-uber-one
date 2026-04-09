package com.personal.project.uberClone.uberApp.services;


import com.personal.project.uberClone.uberApp.entities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);
}
