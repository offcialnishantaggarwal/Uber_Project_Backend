package com.luv2code.project.uber.uberApp.services.impl;

import com.luv2code.project.uber.uberApp.dto.RideDto;
import com.luv2code.project.uber.uberApp.dto.WalletDto;
import com.luv2code.project.uber.uberApp.dto.WalletTransactionDto;
import com.luv2code.project.uber.uberApp.entities.Ride;
import com.luv2code.project.uber.uberApp.entities.User;
import com.luv2code.project.uber.uberApp.entities.Wallet;
import com.luv2code.project.uber.uberApp.entities.WalletTransaction;
import com.luv2code.project.uber.uberApp.enums.TransactionMethod;
import com.luv2code.project.uber.uberApp.enums.TransactionType;
import com.luv2code.project.uber.uberApp.exceptions.ResourceNotFoundException;
import com.luv2code.project.uber.uberApp.repositories.WalletRepository;
import com.luv2code.project.uber.uberApp.services.WalletService;
import com.luv2code.project.uber.uberApp.services.WalletTransactionService;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class WalletServiceImpl implements WalletService {

    private final WalletRepository walletRepository;
    private final WalletTransactionService walletTransactionService;
    private final ModelMapper modelMapper;

    @Override
    @Transactional
    public Wallet addMoneyToWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance() + amount);
        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionType(TransactionType.CREDIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();

        walletTransactionService.createNewWalletTransaction(walletTransaction);
//        wallet.getTransactions().add(walletTransaction);

        return walletRepository.save(wallet);
    }

    @Override
    @Transactional
    public Wallet deductMoneyFromWallet(User user, Double amount, String transactionId, Ride ride, TransactionMethod transactionMethod) {
        Wallet wallet = findByUser(user);
        wallet.setBalance(wallet.getBalance() - amount);
        WalletTransaction walletTransaction = WalletTransaction.builder()
                .transactionId(transactionId)
                .ride(ride)
                .wallet(wallet)
                .transactionType(TransactionType.DEBIT)
                .transactionMethod(transactionMethod)
                .amount(amount)
                .build();

        walletTransactionService.createNewWalletTransaction(walletTransaction);
//        wallet.getTransactions().add(walletTransaction);

        return walletRepository.save(wallet);
    }

    @Override
    public void withdrawAllMyMoneyFromWallet() {

    }

    @Override
    public Wallet findWalletById(Long walletId) {
        return walletRepository
                .findById(walletId)
                .orElseThrow(()-> new ResourceNotFoundException("Wallet not found with id: "+walletId));
    }

    @Override
    public Wallet findByUser(User user) {
        return walletRepository
                .findByUser(user)
                .orElseThrow(()-> new ResourceNotFoundException("Wallet not found for user with id: "+user.getId()));
    }

    @Override
    public Wallet createNewWallet(User user) {
        Wallet wallet = new Wallet();
        wallet.setUser(user);
        return walletRepository.save(wallet)    ;
    }
}
