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
    /*@Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private StudentCheckingRepository studentCheckingRepository;*/

    public Transfer() {
    }

    public Transfer(Long sendingAccount, Long receivingAccount, BigDecimal transferAmount) {
        this.sendingAccount = sendingAccount;
        this.receivingAccount = receivingAccount;
        this.transferAmount = transferAmount;
    }


            /*for(Account a : accounts){
                if(a.getAccountNumber().equals(accountNumber)){
//                    return a;
                }
            }
//            return null;*/
   // }
/*    public Account findAccountByNumber(Long accountNumber){
        Account account = null;
        if (accountNumber == 0) {
            account = checkingRepository.findById(accountNumber).get();
        } else if (accountNumber == 1) {
            account = creditCardRepository.findById(accountNumber).get();
        } else if (accountNumber == 2) {
            account = savingsRepository.findById(accountNumber).get();
        } else if (accountNumber == 3) {
            account = studentCheckingRepository.findById(accountNumber).get();
        }
        return account;
    }*/

/*    public Account findAccountByNumber(Long accountNumber){
        Account account = null;
        switch(accountNumber){
            case 0:
                account = checkingRepository.findById(accountNumber).get();
                break;
            case 1:
                account = creditCardRepository.findById(accountNumber).get();
                break;
            case 2:
                account = savingsRepository.findById(accountNumber).get();
                break;
            case 3:
                account = studentCheckingRepository.findById(accountNumber).get();
                break;
        }
        return account;
    }*/
//    public void transferMoney(Long sendingAccount, Long receivingAccount, BigDecimal amount) throws Exception {
//        if( sendingAccount)
//       Long sender = checkingRepository.findById(sendingAccount).get().accountNumber;
/*        findAccountByNumber(sendingAccount);
        findAccountByNumber(receivingAccount);

        if (sendingAccount == null || receivingAccount == null) {
            throw new Exception("One of the accounts does not exist!");
        }
        System.out.println(sendingAccount.toString());*/
//        if(sendingAccount)
//        if (sendingAccount.getBalance().compareTo(amount) < 0) {
//            throw new Exception("Insufficient funds!");
//        }
//        sendingAccount.setBalance(sendingAccount.getBalance().subtract(amount));
//        receivingAccount.setBalance(receivingAccount.getBalance().add(amount));
//
//        if (sendingAccount.getBalance().compareTo(new BigDecimal(250)) < 0) {
//            sendingAccount.setBalance(sendingAccount.getBalance().subtract(new BigDecimal(40)));
//        }
//        System.out.println("The transfer has been realized with the amount of: " + amount + " from the account: " + sendingAccount  + " with the remaining balance of: " + sendingAccount.getBalance() +"\nThe account " + receivingAccount + " has been credited successfully and shows now the following balance: "+ receivingAccount.getBalance());
//        return null;
//    }


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

