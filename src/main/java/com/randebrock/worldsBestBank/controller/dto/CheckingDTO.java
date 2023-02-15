package com.randebrock.worldsBestBank.controller.dto;

import com.randebrock.worldsBestBank.enums.Status;
import com.randebrock.worldsBestBank.model.Money;
import jakarta.validation.constraints.NotNull;

import java.math.BigDecimal;
import java.util.Date;

public class CheckingDTO {

    private Long accountNumber;
    private Money balance = new Money(BigDecimal.valueOf(0.0));
    @NotNull
    private Long primaryOwner;
    private String optionalSecondaryOwner;
    private BigDecimal penaltyFee;
    @NotNull
    private String secretKey;
    private BigDecimal minimumBalance;
    private BigDecimal monthlyMaintenanceFee;
    private Date creationDate;
    private Status status;
}
