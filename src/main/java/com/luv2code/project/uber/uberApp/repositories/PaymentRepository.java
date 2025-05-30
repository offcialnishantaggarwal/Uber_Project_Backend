package com.luv2code.project.uber.uberApp.repositories;

import com.luv2code.project.uber.uberApp.entities.Payment;
import com.luv2code.project.uber.uberApp.entities.Ride;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Long> {

    Optional<Payment> findByRide(Ride ride);
}
