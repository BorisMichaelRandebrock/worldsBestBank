package com.randebrock.worldsBestBank.model;

import com.randebrock.worldsBestBank.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.math.BigDecimal;
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

    public Checking(AccountHolder primaryOwner, String secretKey) {
        super(primaryOwner);
        this.secretKey = secretKey;
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
