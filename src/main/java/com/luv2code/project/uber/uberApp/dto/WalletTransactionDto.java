package com.luv2code.project.uber.uberApp.dto;

import com.luv2code.project.uber.uberApp.enums.TransactionMethod;
import com.luv2code.project.uber.uberApp.enums.TransactionType;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDateTime;

@Data
@Builder
public class WalletTransactionDto {

    private Long id;

    private Double amount;

    private TransactionType transactionType;

    private TransactionMethod transactionMethod;

    private RideDto ride;

    private WalletDto wallet;

    private String transactionId;

    private LocalDateTime timeStamp;
}
