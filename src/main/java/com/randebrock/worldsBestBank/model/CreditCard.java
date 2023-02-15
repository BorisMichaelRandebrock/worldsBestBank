package com.randebrock.worldsBestBank.model;

import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "accountNumber")
public class CreditCard extends MotherOfAllAccounts{
    private BigDecimal   creditLimit;
    private BigDecimal interestRate;
    private Date creationDate = this.creationDate = Date.from(Instant.now());

    public CreditCard() {
    }

    public CreditCard(AccountHolder primaryOwner, BigDecimal creditLimit, BigDecimal interestRate) {
        super(primaryOwner);
        this.creditLimit = creditLimit;
        this.interestRate = interestRate;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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