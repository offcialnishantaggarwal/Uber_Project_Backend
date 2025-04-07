package com.luv2code.project.uber.uberApp.services;

import com.luv2code.project.uber.uberApp.dto.WalletTransactionDto;
import com.luv2code.project.uber.uberApp.entities.WalletTransaction;

public interface WalletTransactionService {

    void createNewWalletTransaction(WalletTransaction walletTransaction);
}
