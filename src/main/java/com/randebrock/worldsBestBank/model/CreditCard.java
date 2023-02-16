package com.randebrock.worldsBestBank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "accountNumber")
public class CreditCard extends Account {
    private BigDecimal   creditLimit;
    private BigDecimal interestRate;
    private final Date creationDate = Date.from(Instant.now());

    public CreditCard() {
    }

    public CreditCard(AccountHolder primaryOwner, AccountHolder optionalSecodaryOwner) {
        super(primaryOwner, optionalSecodaryOwner);
        this.creditLimit = new BigDecimal(100);
        this.interestRate= new BigDecimal(0.2);
    }

    public CreditCard(AccountHolder primaryOwner, AccountHolder optionalSecondaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        super(primaryOwner, optionalSecondaryOwner);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public Date getCreationDate() {
        return creationDate;
    }


    public BigDecimal getCreditLimit() {
        return creditLimit;
    }

    public void setCreditLimit(BigDecimal creditLimit) {
        this.creditLimit = creditLimit;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
