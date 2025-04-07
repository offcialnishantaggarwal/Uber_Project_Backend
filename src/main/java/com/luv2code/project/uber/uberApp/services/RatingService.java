package com.luv2code.project.uber.uberApp.services;

import com.luv2code.project.uber.uberApp.dto.DriverDto;
import com.luv2code.project.uber.uberApp.dto.RiderDto;
import com.luv2code.project.uber.uberApp.entities.Driver;
import com.luv2code.project.uber.uberApp.entities.Ride;
import com.luv2code.project.uber.uberApp.entities.Rider;

public interface RatingService {

    DriverDto rateDriver(Ride ride, Integer rating);

    RiderDto rateRider(Ride ride, Integer rating);

    void createNewRating(Ride ride);

}
