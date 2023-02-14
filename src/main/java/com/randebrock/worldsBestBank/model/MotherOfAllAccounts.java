package com.randebrock.worldsBestBank.model;


import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.Date;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
abstract class MotherOfAllAccounts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long accountNumber;
    @Embedded
    @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "balance_currency"))
    })
    Money balance = new Money(BigDecimal.valueOf(0.0));
    String primaryOwner;
    String optionalSecondaryOwner;
    BigDecimal penaltyFee;


    public MotherOfAllAccounts() {
    }

    public MotherOfAllAccounts(String primaryOwner, BigDecimal penaltyFee) {
        this.primaryOwner = primaryOwner;
        this.penaltyFee = penaltyFee;
    }

    public MotherOfAllAccounts( String primaryOwner, String optionalSecondaryOwner, BigDecimal penaltyFee) {
        this.primaryOwner = primaryOwner;
        this.optionalSecondaryOwner = optionalSecondaryOwner;
        this.penaltyFee = penaltyFee;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(Long accountNumber) {
        this.accountNumber = accountNumber;
    }

    public Money getBalance() {
        return balance;
    }

    public void setBalance(Money balance) {
        this.balance = balance;
    }

    public String getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(String primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public String getOptionalSecondaryOwner() {
        return optionalSecondaryOwner;
    }

    public void setOptionalSecondaryOwner(String optionalSecondaryOwner) {
        this.optionalSecondaryOwner = optionalSecondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }
}
