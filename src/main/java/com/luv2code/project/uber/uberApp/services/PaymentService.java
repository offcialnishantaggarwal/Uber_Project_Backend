package com.luv2code.project.uber.uberApp.services;

import com.luv2code.project.uber.uberApp.entities.Payment;
import com.luv2code.project.uber.uberApp.entities.Ride;
import com.luv2code.project.uber.uberApp.enums.PaymentStatus;

public interface PaymentService {

    void processPayment(Ride ride);

    Payment createNewPayment(Ride ride);

    void updatePaymentStatus(Payment payment, PaymentStatus paymentStatus);
}
