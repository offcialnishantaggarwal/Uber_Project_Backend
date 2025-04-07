package com.luv2code.project.uber.uberApp.services;

import com.luv2code.project.uber.uberApp.entities.RideRequest;

public interface RideRequestService {

    RideRequest findRideRequestById(Long rideRequestId);

    void update(RideRequest rideRequest);
}
