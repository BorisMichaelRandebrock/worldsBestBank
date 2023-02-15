package com.randebrock.worldsBestBank.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

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
    @ManyToOne
    @JoinColumn(name = "primaryOwner")
    AccountHolder primaryOwner;
    @ManyToOne
    @JoinColumn(name = "secondaryOwner")
    AccountHolder optionalSecondaryOwner;
    BigDecimal penaltyFee;


    public MotherOfAllAccounts() {
    }

    public MotherOfAllAccounts(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
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

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        this.primaryOwner = primaryOwner;
    }

    public AccountHolder getOptionalSecondaryOwner() {
        return optionalSecondaryOwner;
    }

    public void setOptionalSecondaryOwner(AccountHolder optionalSecondaryOwner) {
        this.optionalSecondaryOwner = optionalSecondaryOwner;
    }

    public BigDecimal getPenaltyFee() {
        return penaltyFee;
    }

    public void setPenaltyFee(BigDecimal penaltyFee) {
        this.penaltyFee = penaltyFee;
    }
}
