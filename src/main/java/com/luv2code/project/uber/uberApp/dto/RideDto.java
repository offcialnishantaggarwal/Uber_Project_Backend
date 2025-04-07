package com.luv2code.project.uber.uberApp.dto;

import com.luv2code.project.uber.uberApp.enums.PaymentMethod;
import com.luv2code.project.uber.uberApp.enums.RideStatus;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class RideDto {

    private Long id;
    private PointDto pickupLocation;
    private PointDto dropOffLocation;
    private LocalDateTime createdTime;
    private RiderDto rider;
    private DriverDto driver;
    private PaymentMethod paymentMethod;
    private RideStatus rideStatus;
    private String otp;
    private Double fare;
    private LocalDateTime startedAt;
    private LocalDateTime endedAt;
}
