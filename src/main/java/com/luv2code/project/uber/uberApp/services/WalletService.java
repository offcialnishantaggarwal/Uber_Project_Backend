package com.luv2code.project.uber.uberApp.services;

import com.luv2code.project.uber.uberApp.entities.Ride;
import com.luv2code.project.uber.uberApp.entities.User;
import com.luv2code.project.uber.uberApp.entities.Wallet;
import com.luv2code.project.uber.uberApp.enums.TransactionMethod;

import java.util.Optional;

public interface WalletService {

    Wallet addMoneyToWallet(User user, Double amount, String transactionId,
                            Ride ride, TransactionMethod transactionMethod);

    Wallet deductMoneyFromWallet(User user, Double amount, String transactionId,
                                 Ride ride, TransactionMethod transactionMethod);

    void withdrawAllMyMoneyFromWallet();

    Wallet findWalletById(Long walletId);

    Wallet findByUser(User user);

    Wallet createNewWallet(User user);
}
