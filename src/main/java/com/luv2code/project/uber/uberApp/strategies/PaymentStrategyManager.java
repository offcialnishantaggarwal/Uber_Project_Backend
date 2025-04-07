package com.luv2code.project.uber.uberApp.strategies;

import com.luv2code.project.uber.uberApp.enums.PaymentMethod;
import com.luv2code.project.uber.uberApp.strategies.impl.CashPaymentStrategy;
import com.luv2code.project.uber.uberApp.strategies.impl.WalletPaymentStrategy;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class PaymentStrategyManager {

    private final CashPaymentStrategy cashPaymentStrategy;
    private final WalletPaymentStrategy walletPaymentStrategy;

    public PaymentStrategy paymentStrategy(PaymentMethod paymentMethod){
        return switch (paymentMethod){
            case CASH -> cashPaymentStrategy;
            case WALLET -> walletPaymentStrategy;
            default -> throw new RuntimeException("Invalid Payment Method");
        };
    }


}
