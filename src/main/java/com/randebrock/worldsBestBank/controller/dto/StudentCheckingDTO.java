package com.randebrock.worldsBestBank.controller.dto;

import com.randebrock.worldsBestBank.model.AccountHolder;
import jakarta.validation.constraints.NotNull;

import java.time.*;
import java.util.Date;

public class StudentCheckingDTO {

    @NotNull
    private AccountHolder primaryOwner;
    private AccountHolder optionalSecondaryOwner;
    @NotNull
    private String secretKey;

    public StudentCheckingDTO(AccountHolder primaryOwner, AccountHolder optionalSecondaryOwner, String secretKey) {
        setPrimaryOwner(primaryOwner);
        this.optionalSecondaryOwner = optionalSecondaryOwner;
        this.secretKey = secretKey;
    }

    public AccountHolder getPrimaryOwner() {
        return primaryOwner;
    }

    public void setPrimaryOwner(AccountHolder primaryOwner) {
        Date dob = primaryOwner.getDateOfBirth();
        Date today = Date.from(Instant.now());
        LocalDate now = LocalDateTime.ofInstant(today.toInstant(), ZoneId.systemDefault()).toLocalDate();
        LocalDate birthday = LocalDateTime.ofInstant(dob.toInstant(), ZoneId.systemDefault()).toLocalDate();
        Period p = Period.between(birthday, now);
        int age = p.getYears();

        if(age < 24) {
            this.primaryOwner = primaryOwner;
        } else {
            throw new IllegalArgumentException("You have to be under 24 to be able to open a student checking account.");
        }

    }

    public AccountHolder getOptionalSecondaryOwner() {
        return optionalSecondaryOwner;
    }

    public void setOptionalSecondaryOwner(AccountHolder optionalSecondaryOwner) {
        this.optionalSecondaryOwner = optionalSecondaryOwner;
    }

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
