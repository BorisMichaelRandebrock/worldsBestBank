package com.randebrock.worldsBestBank.controller.dto;

import com.randebrock.worldsBestBank.model.AccountHolder;
import com.randebrock.worldsBestBank.model.Money;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.time.Instant;
import java.util.Date;

public class CreditCardDTO {

    @NotNull
    private AccountHolder primaryOwner;
    private AccountHolder optionalSecondaryOwner;

    public CreditCardDTO(AccountHolder primaryOwner, AccountHolder optionalSecondaryOwner) {
        this.primaryOwner = primaryOwner;
        this.optionalSecondaryOwner = optionalSecondaryOwner;
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
}

