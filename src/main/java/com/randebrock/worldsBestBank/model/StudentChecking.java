package com.randebrock.worldsBestBank.model;

import com.randebrock.worldsBestBank.enums.Status;
import jakarta.persistence.Entity;
import jakarta.persistence.PrimaryKeyJoinColumn;

import java.time.Instant;
import java.util.Date;

@Entity
@PrimaryKeyJoinColumn(name = "accountNumber")
public class StudentChecking extends Account {
    private String secretKey;
    private final Date creationDate = Date.from(Instant.now());
    private Status status;

    public StudentChecking() {
    }

    public StudentChecking(AccountHolder primaryOwner, AccountHolder optionalSecondaryOwner , String secretKey) {
        super(primaryOwner, optionalSecondaryOwner);
        this.secretKey = secretKey;
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

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
