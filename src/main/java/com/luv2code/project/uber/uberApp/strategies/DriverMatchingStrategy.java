package com.luv2code.project.uber.uberApp.strategies;

import com.luv2code.project.uber.uberApp.entities.Driver;
import com.luv2code.project.uber.uberApp.entities.RideRequest;

import java.util.List;

public interface DriverMatchingStrategy {

    List<Driver> findMatchingDriver(RideRequest rideRequest);
}
