package com.luv2code.project.uber.uberApp.strategies.impl;

import com.luv2code.project.uber.uberApp.entities.Driver;
import com.luv2code.project.uber.uberApp.entities.Payment;
import com.luv2code.project.uber.uberApp.enums.PaymentStatus;
import com.luv2code.project.uber.uberApp.enums.TransactionMethod;
import com.luv2code.project.uber.uberApp.repositories.PaymentRepository;
import com.luv2code.project.uber.uberApp.services.PaymentService;
import com.luv2code.project.uber.uberApp.services.WalletService;
import com.luv2code.project.uber.uberApp.strategies.PaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

//Rider ->100
//Dirver -> 70 deducting 30 from driver wallet
//

@Service
@RequiredArgsConstructor
public class CashPaymentStrategy implements PaymentStrategy {

    private final WalletService walletService;
    private final PaymentRepository paymentRepository;

    @Override
    public void processPayment(Payment payment) {
        Driver driver = payment.getRide().getDriver();
        double platformCommission = payment.getAmount() * PLATFORM_COMMISSION;
        walletService.deductMoneyFromWallet(driver.getUser(), platformCommission, null,
                payment.getRide(), TransactionMethod.RIDE);

        payment.setPaymentStatus(PaymentStatus.CONFIRMED);
        paymentRepository.save(payment);
    }
}
