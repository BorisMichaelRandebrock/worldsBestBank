package com.randebrock.worldsBestBank.controller.dto;

import com.randebrock.worldsBestBank.model.AccountHolder;
import jakarta.persistence.Id;

import java.math.BigDecimal;

public class TransferDTO {

    private Long id;
    private Long sendingAccount;
    private Long receivingAccount;
    private BigDecimal transferAmount;

    public TransferDTO() {
    }

    public TransferDTO(Long sendingAccount, Long receivingAccount, BigDecimal transferAmount) {
        this.sendingAccount = sendingAccount;
        this.receivingAccount = receivingAccount;
        this.transferAmount = transferAmount;
    }

    public Long getSendingAccount() {
        return sendingAccount;
    }

    public void setSendingAccount(Long sendingAccount) {
        this.sendingAccount = sendingAccount;
    }

    public Long getReceivingAccount() {
        return receivingAccount;
    }

    public void setReceivingAccount(Long receivingAccount) {
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
