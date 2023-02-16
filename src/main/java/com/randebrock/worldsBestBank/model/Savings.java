package com.randebrock.worldsBestBank.model;

import com.randebrock.worldsBestBank.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
@Entity
@PrimaryKeyJoinColumn(name = "accountNumber")
public class Savings extends Account {
    private String secretKey;
    private BigDecimal minimumBalance;
    private final Date creationDate = Date.from(Instant.now());
    private Status status;
    private BigDecimal interestRate;

    public Savings() {
    }

    public Savings(AccountHolder primaryOwner, AccountHolder optionalSecondaryOwner, String secretKey, BigDecimal interestRate, BigDecimal minimumBalance) {
        super(primaryOwner, optionalSecondaryOwner);
        this.secretKey = secretKey;
        this.status = Status.ACTIVE;
    }
    public Savings(AccountHolder primaryOwner, AccountHolder optionalSecondaryOwner, String secretKey) {
        super(primaryOwner, optionalSecondaryOwner);
        this.secretKey = secretKey;
        this.minimumBalance = new BigDecimal(1000);
        this.status = Status.ACTIVE;
        this.interestRate = new BigDecimal(0.0025);
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }

    public BigDecimal getMinimumBalance() {
        return minimumBalance;
    }

    public void setMinimumBalance(BigDecimal minimumBalance) {
        this.minimumBalance = minimumBalance;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public BigDecimal getInterestRate() {
        return interestRate;
    }

    public void setInterestRate(BigDecimal interestRate) {
        this.interestRate = interestRate;
    }
}
