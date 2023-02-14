package com.randebrock.worldsBestBank.model;

import com.randebrock.worldsBestBank.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "accountNumber")
public class StudentChecking extends MotherOfAllAccounts{
    private String secretKey;
    private Date creationDate;
    private Status status;

    public StudentChecking() {
    }

    public StudentChecking(String primaryOwner, BigDecimal penaltyFee, String secretKey) {
        super(primaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.creationDate = Date.from(Instant.now());
        this.status = Status.ACTIVE;
    }

    public StudentChecking(String primaryOwner, String optionalSecondaryOwner, BigDecimal penaltyFee, String secretKey) {
        super(primaryOwner, optionalSecondaryOwner, penaltyFee);
        this.secretKey = secretKey;
        this.creationDate = Date.from(Instant.now());
        this.status = Status.ACTIVE;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
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
