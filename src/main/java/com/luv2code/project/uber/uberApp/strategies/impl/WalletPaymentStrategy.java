package com.luv2code.project.uber.uberApp.strategies.impl;

import com.luv2code.project.uber.uberApp.entities.Driver;
import com.luv2code.project.uber.uberApp.entities.Payment;
import com.luv2code.project.uber.uberApp.entities.Rider;
import com.luv2code.project.uber.uberApp.enums.PaymentStatus;
import com.luv2code.project.uber.uberApp.enums.TransactionMethod;
import com.luv2code.project.uber.uberApp.repositories.PaymentRepository;
import com.luv2code.project.uber.uberApp.services.PaymentService;
import com.luv2code.project.uber.uberApp.services.WalletService;
import com.luv2code.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

// Rider had 232rs, Driver had 500rs
// Ride cost is 100, commission is 30
// Rider 232-100=132
// Driver -> 500 + (100-30) = 570

@Service
@RequiredArgsConstructor
public class WalletPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    @Transactional
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        Rider rider = payment.getRide().getRider();

        walletService.deductMoneyFromWallet(rider.getUser(),
                payment.getAmount(), null, payment.getRide(),
                TransactionMethod.RIDE);

        double driversCut = payment.getAmount() * (1 - PLATFORM_COMMISSION);

        walletService.addMoneyToWallet(driver.getUser(),
                driversCut, null, payment.getRide(),
                TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
