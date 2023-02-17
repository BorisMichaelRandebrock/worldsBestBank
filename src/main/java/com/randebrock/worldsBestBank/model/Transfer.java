package com.randebrock.worldsBestBank.model;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
public class Transfer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "sending_id")
    private AccountHolder sendingAccount;
    @ManyToOne
    @JoinColumn(name = "receiving_id")
    private AccountHolder receivingAccount;
    private BigDecimal transferAmount;

    public Transfer() {
    }

    public Transfer(AccountHolder sendingAccount, AccountHolder receivingAccount, BigDecimal transferAmount) {
        this.sendingAccount = sendingAccount;
        this.receivingAccount = receivingAccount;
        this.transferAmount = transferAmount;
    }

    public void transferMoney(AccountHolder sendingAccount, AccountHolder receivingAccount, BigDecimal amount) throws Exception {
        sendingAccount = AccountHolder.findByOwnerIdAndAccountId(sendingAccount);
        receivingAccount = AccountHolder.findByAccountId(receivingAccount);
        if (sendingAccount == null || receivingAccount == null) {
            throw new Exception("Accounts does not exist!");
        }

        if (sendingAccount.getBalance().compareTo(amount) < 0) {
            throw new Exception("Insufficient funds!");
        }
        sendingAccount.setBalance(sendingAccount.getBalance().subtract(amount));
        receivingAccount.setBalance(receivingAccount.getBalance().add(amount));

        if (sendingAccount.getBalance().compareTo(new BigDecimal(40)) < 0) {
            sendingAccount.setBalance(sendingAccount.getBalance().subtract(new BigDecimal(40)));
        }
        System.out.println("The transfer has been realized with the amount of: " + amount + " from the account: " + sendingAccount  + " with the remaining balance of: " + sendingAccount.getBalance() +"\nThe account " + receivingAccount + " has been credited successfully and shows now the following balance: "+ receivingAccount.getBalance());
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AccountHolder getSendingAccount() {
        return sendingAccount;
    }

    public void setSendingAccount(AccountHolder sendingAccount) {
        this.sendingAccount = sendingAccount;
    }

    public AccountHolder getReceivingAccount() {
        return receivingAccount;
    }

    public void setReceivingAccount(AccountHolder receivingAccount) {
        this.receivingAccount = receivingAccount;
    }

    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }
}

