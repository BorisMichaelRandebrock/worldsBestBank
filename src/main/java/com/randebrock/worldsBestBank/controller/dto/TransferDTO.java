package com.randebrock.worldsBestBank.controller.dto;

import com.randebrock.worldsBestBank.model.AccountHolder;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class TransferDTO {

    private Long id;
    private AccountHolder sendingAccount;
    private AccountHolder receivingAccount;
    private BigDecimal transferAmount;

    public TransferDTO(AccountHolder sendingAccount, AccountHolder receivingAccount, BigDecimal transferAmount) {
        this.sendingAccount = sendingAccount;
        this.receivingAccount = receivingAccount;
        this.transferAmount = transferAmount;
    }

    public AccountHolder getSendingAccount() {
        return sendingAccount;
    }

    public void setSendingAccount(AccountHolder sendingAccount) {
        this.sendingAccount = sendingAccount;
    }

    public AccountHolder getReceivingAccount() {
        return receivingAccount;
    }

    public void setReceivingAccount(AccountHolder receivingAccount) {
        this.receivingAccount = receivingAccount;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
