package com.luv2code.project.uber.uberApp.strategies;

import com.luv2code.project.uber.uberApp.entities.RideRequest;

public interface RideFareCalculationStrategy {

    double RIDE_FARE_MULTIPLER = 10;

    double calculateFare(RideRequest rideRequest);
}
