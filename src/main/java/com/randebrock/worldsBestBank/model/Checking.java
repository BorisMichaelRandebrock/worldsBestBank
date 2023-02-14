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
public class Checking extends MotherOfAllAccounts{
    private String secretKey;
    private BigDecimal minimumBalance;
    private BigDecimal monthlyMaintenanceFee;
    private Date creationDate;
    private Status status;

    public Checking() {
    }

    public Checking(String primaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
        super(primaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.creationDate = Date.from(Instant.now());
        this.status = Status.ACTIVE;
    }

    public Checking(String primaryOwner, String optionalSecondaryOwner, BigDecimal penaltyFee, String secretKey, BigDecimal minimumBalance, BigDecimal monthlyMaintenanceFee) {
        super( primaryOwner, optionalSecondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.minimumBalance = minimumBalance;
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
        this.creationDate = Date.from(Instant.now());
        this.status = Status.ACTIVE;

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

    public BigDecimal getMonthlyMaintenanceFee() {
        return monthlyMaintenanceFee;
    }

    public void setMonthlyMaintenanceFee(BigDecimal monthlyMaintenanceFee) {
        this.monthlyMaintenanceFee = monthlyMaintenanceFee;
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
}
