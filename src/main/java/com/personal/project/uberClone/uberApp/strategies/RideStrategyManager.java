package com.personal.project.uberClone.uberApp.strategies;

import com.personal.project.uberClone.uberApp.strategies.impl.DriverMatchingHighestRatedDriver;
import com.personal.project.uberClone.uberApp.strategies.impl.DriverMatchingNearestDriver;
import com.personal.project.uberClone.uberApp.strategies.impl.RideFareDefaultFareCalculation;
import com.personal.project.uberClone.uberApp.strategies.impl.RideFareSurgePricingFareCalculation;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.LocalTime;

@Component
@RequiredArgsConstructor
public class RideStrategyManager {

    private final DriverMatchingHighestRatedDriver highestRatedDriverStrategy;
    private final DriverMatchingNearestDriver nearestDriverStrategy;
    private final RideFareSurgePricingFareCalculation surgePricingFareCalculationStrategy;
    private final RideFareDefaultFareCalculation defaultFareCalculationStrategy;

    public DriverMatchingStrategy driverMatchingStrategy(double riderRating) {
        if(riderRating >= 4.8) {
            return highestRatedDriverStrategy;
        } else {
            return nearestDriverStrategy;
        }
    }

    public RideFareCalculationStrategy rideFareCalculationStrategy() {

//        6PM to 9PM is SURGE TIME
        LocalTime surgeStartTime = LocalTime.of(18, 0);
        LocalTime surgeEndTime = LocalTime.of(21, 0);
        LocalTime currentTime = LocalTime.now();

        boolean isSurgeTime = currentTime.isAfter(surgeStartTime) && currentTime.isBefore(surgeEndTime);

        if(isSurgeTime) {
            return surgePricingFareCalculationStrategy;
        } else {
            return defaultFareCalculationStrategy;
        }
    }

}
