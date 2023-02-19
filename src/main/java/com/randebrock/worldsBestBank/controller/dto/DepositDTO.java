package com.randebrock.worldsBestBank.controller.dto;

import com.randebrock.worldsBestBank.model.Money;

import java.math.BigDecimal;

public class DepositDTO {
    private Long accountId;
    private String accountType;
    private Money amount;

    public Long getAccountId() {
        return accountId;
    }

    public void setAccountId(Long accountId) {
        this.accountId = accountId;
    }

    public String getAccountType() {
        return accountType;
    }

    public void setAccountType(String accountType) {
        this.accountType = accountType;
    }

    public Money getAmount() {
        return amount;
    }

    public void setAmount(Money amount) {
        this.amount = amount;
    }
}
