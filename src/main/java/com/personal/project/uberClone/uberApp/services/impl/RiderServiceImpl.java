package com.personal.project.uberClone.uberApp.services.impl;

import com.personal.project.uberClone.uberApp.dto.DriverDto;
import com.personal.project.uberClone.uberApp.dto.RideDto;
import com.personal.project.uberClone.uberApp.dto.RideRequestDto;
import com.personal.project.uberClone.uberApp.dto.RiderDto;
import com.personal.project.uberClone.uberApp.entities.RideRequest;
import com.personal.project.uberClone.uberApp.entities.Rider;
import com.personal.project.uberClone.uberApp.entities.User;
import com.personal.project.uberClone.uberApp.entities.enums.RideRequestStatus;
import com.personal.project.uberClone.uberApp.repositories.RideRequestRepository;
import com.personal.project.uberClone.uberApp.repositories.RiderRepository;
import com.personal.project.uberClone.uberApp.services.RiderService;
import com.personal.project.uberClone.uberApp.strategies.DriverMatchingStrategy;
import com.personal.project.uberClone.uberApp.strategies.RideFareCalculationStrategy;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
@Slf4j
public class RiderServiceImpl implements RiderService {

    private final ModelMapper modelMapper;
    private final RideFareCalculationStrategy rideFareCalculationStrategy;
    private final DriverMatchingStrategy driverMatchingStrategy;
    private final RideRequestRepository rideRequestRepository;
    private final RiderRepository riderRepository;

    @Override
    public RideRequestDto requestRide(RideRequestDto rideRequestDto) {
        RideRequest rideRequest = modelMapper.map(rideRequestDto, RideRequest.class);
        rideRequest.setRideRequestStatus(RideRequestStatus.PENDING);

        Double fare  = rideFareCalculationStrategy.calculateFare(rideRequest);
        rideRequest.setFare(fare);

        RideRequest savedRideRequest= rideRequestRepository.save(rideRequest);

        driverMatchingStrategy.findMatchingDriver(rideRequest);

        log.info(rideRequest.toString());

        return modelMapper.map(savedRideRequest, RideRequestDto.class);
    }

    @Override
    public RideDto cancelRide(Long rideId) {
        return null;
    }

    @Override
    public DriverDto rateDriver(Long rideId, Integer rating) {
        return null;
    }

    @Override
    public RiderDto getMyProfile() {
        return null;
    }

    @Override
    public List<RideDto> getAllMyRides() {
        return List.of();
    }

    @Override
    public Rider createNewRider(User user) {
        Rider rider = new Rider().
                builder().user(user).rating(0.0).build();
        return riderRepository.save(rider);
    }
}
