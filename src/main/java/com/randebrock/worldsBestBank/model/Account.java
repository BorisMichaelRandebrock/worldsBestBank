package com.randebrock.worldsBestBank.model;


import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Inheritance(strategy = InheritanceType.JOINED)
public abstract class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long accountNumber;
    @Embedded
   /* @AttributeOverrides({
            @AttributeOverride(name = "amount", column = @Column(name = "balance_amount")),
            @AttributeOverride(name = "currency", column = @Column(name = "balance_currency"))
    })*/
    Money balance;
    @ManyToOne
    @JoinColumn(name = "primaryOwner")
    AccountHolder primaryOwner;
    @ManyToOne
    @JoinColumn(name = "secondaryOwner")
    AccountHolder optionalSecondaryOwner;
    BigDecimal penaltyFee;


    public Account() {
    }

    public Account(AccountHolder primaryOwner, AccountHolder optionalSecondaryOwner) {
        this.balance = new Money(new BigDecimal(0));
        this.primaryOwner = primaryOwner;
        this.optionalSecondaryOwner = optionalSecondaryOwner;
        this.penaltyFee = new BigDecimal(40);
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
