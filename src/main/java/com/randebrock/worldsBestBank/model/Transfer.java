package com.randebrock.worldsBestBank.model;

import com.randebrock.worldsBestBank.repository.CheckingRepository;
import com.randebrock.worldsBestBank.repository.CreditCardRepository;
import com.randebrock.worldsBestBank.repository.SavingsRepository;
import com.randebrock.worldsBestBank.repository.StudentCheckingRepository;
import jakarta.persistence.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.math.BigDecimal;
import java.util.Optional;

@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
//    @ManyToOne
//    @JoinColumn(name = "sending_id")
    private Long sendingAccount;
//    @ManyToOne
//    @JoinColumn(name = "receiving_id")
    private Long receivingAccount;
    private BigDecimal transferAmount;


    public Transfer() {
    }

    public Transfer(Long sendingAccount, Long receivingAccount, BigDecimal transferAmount) {
        this.sendingAccount = sendingAccount;
        this.receivingAccount = receivingAccount;
        this.transferAmount = transferAmount;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getSendingAccount() {
        return sendingAccount;
    }

    public void setSendingAccount(Long sendingAccount) {
        this.sendingAccount = sendingAccount;
    }

    public Long getReceivingAccount() {
        return receivingAccount;
    }

    public void setReceivingAccount(Long receivingAccount) {
        this.receivingAccount = receivingAccount;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }
}

