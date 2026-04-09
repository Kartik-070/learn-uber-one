package com.personal.project.uberClone.uberApp.dto;

import com.personal.project.uberClone.uberApp.entities.enums.PaymentMethod;
import com.personal.project.uberClone.uberApp.entities.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class  RideRequestDto {
    private Long id;

    private PointDto pickupLocation;
    private PointDto dropOffLocation;

    private LocalDateTime requestedTime;

    private RiderDto rider ;
    private Double fare;

    private PaymentMethod paymentMethod;

    private RideRequestStatus rideRequestStatus;


}
