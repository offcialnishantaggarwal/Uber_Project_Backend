package com.luv2code.project.uber.uberApp.dto;

import com.luv2code.project.uber.uberApp.enums.PaymentMethod;
import com.luv2code.project.uber.uberApp.enums.RideRequestStatus;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RideRequestDto {

    private Long id;

    private PointDto pickupLocation;
    private PointDto dropOffLocation;
    private PaymentMethod paymentMethod;

    private LocalDateTime requestedTime;
    private RiderDto rider;
    private Double fare;
    private RideRequestStatus rideRequestStatus;
}
