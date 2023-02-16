package com.randebrock.worldsBestBank.controller.dto;

import com.randebrock.worldsBestBank.model.AccountHolder;
import jakarta.validation.constraints.NotNull;

public class StudentCheckingDTO {

    @NotNull
    private AccountHolder primaryOwner;
    private AccountHolder optionalSecondaryOwner;
    @NotNull
    private String secretKey;

    public StudentCheckingDTO(AccountHolder primaryOwner, AccountHolder optionalSecondaryOwner, String secretKey) {
        this.primaryOwner = primaryOwner;
        this.optionalSecondaryOwner = optionalSecondaryOwner;
        this.secretKey = secretKey;
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

    public String getSecretKey() {
        return secretKey;
    }

    public void setSecretKey(String secretKey) {
        this.secretKey = secretKey;
    }
}
