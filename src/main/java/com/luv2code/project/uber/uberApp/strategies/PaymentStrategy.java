package com.luv2code.project.uber.uberApp.strategies;

import com.luv2code.project.uber.uberApp.entities.Payment;

public interface PaymentStrategy {

    Double PLATFORM_COMMISSION = 0.3;

    void processPayment(Payment payment);
}
