package com.randebrock.worldsBestBank.model;

import com.randebrock.worldsBestBank.enums.Status;
import jakarta.persistence.Embedded;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;
@Entity
@PrimaryKeyJoinColumn(name = "accountNumber")
public class Savings extends MotherOfAllAccounts{
    private String secretKey;
    private BigDecimal minimumBalance;
    private Date creationDate;
    private Status status;
    private BigDecimal interestRate;

    public Savings() {
    }

    public Savings(AccountHolder primaryOwner, String secretKey, BigDecimal minimumBalance, BigDecimal interestRate) {
        super(primaryOwner);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.creationDate = Date.from(Instant.now());
        this.status = Status.ACTIVE;
        this.interestRate = interestRate;
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

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
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
