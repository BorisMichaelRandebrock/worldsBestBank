package com.randebrock.worldsBestBank.service.impl;

import com.randebrock.worldsBestBank.controller.dto.DepositDTO;
import com.randebrock.worldsBestBank.controller.dto.TransferDTO;
import com.randebrock.worldsBestBank.controller.dto.WithdrawDTO;
import com.randebrock.worldsBestBank.model.*;
import com.randebrock.worldsBestBank.repository.*;
import com.randebrock.worldsBestBank.service.interfaces.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
public class AccountHolderServiceImpl implements AccountHolderService {
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private StudentCheckingRepository studentCheckingRepository;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<AccountHolder> getUsers() {
        return accountHolderRepository.findAll();
    }

    public AccountHolder addAccountHolder(AccountHolder accountHolder) {
        accountHolder.setPassword(passwordEncoder.encode(accountHolder.getPassword()));
        return accountHolderRepository.save(accountHolder);
    }

    @Override
    public Transfer makeTransfer(TransferDTO transferDTO) {
        /*
        Optional<Checking> optionalChecking = checkingRepository.findById(transferDTO.getReceivingAccount());
        if(optionalChecking.isPresent()){
            Checking receivingAccount = optionalChecking.get();
            Money newBalance = new Money(receivingAccount.getBalance().increaseAmount(new Money(transferDTO.getTransferAmount())));
            receivingAccount.setBalance(newBalance);

        }
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(transferDTO.getReceivingAccount());
        if(optionalCreditCard.isPresent()){
            CreditCard receivingAccount = optionalCreditCard.get();
            Money newBalance = new Money(receivingAccount.getBalance().increaseAmount(new Money(transferDTO.getTransferAmount())));
            receivingAccount.setBalance(newBalance);
        }
        Optional<Savings> optionalSavings = savingsRepository.findById(transferDTO.getReceivingAccount());
        if(optionalSavings.isPresent()){
            Savings receivingAccount = optionalSavings.get();
            Money newBalance = new Money(receivingAccount.getBalance().increaseAmount(new Money(transferDTO.getTransferAmount())));
            receivingAccount.setBalance(newBalance);
        }
        Optional<StudentChecking> optionalStudentChecking = studentCheckingRepository.findById(transferDTO.getReceivingAccount());
        if(optionalStudentChecking.isPresent()){
            StudentChecking receivingAccount = optionalStudentChecking.get();
            Money newBalance = new Money(receivingAccount.getBalance().increaseAmount(new Money(transferDTO.getTransferAmount())));
            receivingAccount.setBalance(newBalance);
        }
        if(!optionalChecking.isPresent() && !optionalCreditCard.isPresent() && !optionalSavings.isPresent() && !optionalStudentChecking.isPresent() ){
            throw new IllegalArgumentException("Receiving account does not exist!!");
        }

        Optional<Checking> checkingOptional = checkingRepository.findById(transferDTO.getSendingAccount());
        if(checkingOptional.isPresent()){
            Checking myAccount = checkingOptional.get();
            if(myAccount.getBalance().getAmount().compareTo(transferDTO.getTransferAmount()) < 0){
                throw new IllegalArgumentException("insufficient funds");
            }
            Money newBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(transferDTO.getTransferAmount())));
            myAccount.setBalance( newBalance);
            if(myAccount.getBalance().getAmount().compareTo(new Money(new BigDecimal(250)).getAmount()) < 0){
             Money newPenalisedBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(new BigDecimal(40))));
                myAccount.setBalance(newPenalisedBalance);
            }

        }

        Optional<CreditCard> creditCardOptional = creditCardRepository.findById(transferDTO.getSendingAccount());
        if(creditCardOptional.isPresent()){
            CreditCard myAccount = creditCardOptional.get();
            if(myAccount.getBalance().getAmount().compareTo(transferDTO.getTransferAmount()) < 0){
                throw new IllegalArgumentException("insufficient funds");
            }
            Money newBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(transferDTO.getTransferAmount())));
            myAccount.setBalance( newBalance);
            if(myAccount.getBalance().getAmount().compareTo(new Money(new BigDecimal(250)).getAmount()) < 0){
                Money newPenalisedBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(new BigDecimal(40))));
                myAccount.setBalance(newPenalisedBalance);
            }
        }
        Optional<Savings> savingsOptional = savingsRepository.findById(transferDTO.getSendingAccount());
        if(savingsOptional.isPresent()){
            Savings myAccount = savingsOptional.get();
            if(myAccount.getBalance().getAmount().compareTo(transferDTO.getTransferAmount()) < 0){
                throw new IllegalArgumentException("insufficient funds");
            }
            Money newBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(transferDTO.getTransferAmount())));
            myAccount.setBalance( newBalance);
            if(myAccount.getBalance().getAmount().compareTo(new Money(new BigDecimal(250)).getAmount()) < 0){
                Money newPenalisedBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(new BigDecimal(40))));
                myAccount.setBalance(newPenalisedBalance);
            }
        }

        Optional<StudentChecking> studentCheckingOptional = studentCheckingRepository.findById(transferDTO.getSendingAccount());
        if(studentCheckingOptional.isPresent()){
            StudentChecking myAccount = studentCheckingOptional.get();
            if(myAccount.getBalance().getAmount().compareTo(transferDTO.getTransferAmount()) < 0){
                throw new IllegalArgumentException("insufficient funds");
            }
            Money newBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(transferDTO.getTransferAmount())));
            myAccount.setBalance( newBalance);
            if(myAccount.getBalance().getAmount().compareTo(new Money(new BigDecimal(250)).getAmount()) < 0){
                Money newPenalisedBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(new BigDecimal(40))));
                myAccount.setBalance(newPenalisedBalance);
            }

        }

        if(!checkingOptional.isPresent() && !creditCardOptional.isPresent() && !savingsOptional.isPresent() && !studentCheckingOptional.isPresent() ){
            throw new IllegalArgumentException("Origin account does not exist!!");
        }
*/


        Optional<Checking> optionalChecking = checkingRepository.findById(transferDTO.getReceivingAccount());
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(transferDTO.getReceivingAccount());
        Optional<Savings> optionalSavings = savingsRepository.findById(transferDTO.getReceivingAccount());
        Optional<StudentChecking> optionalStudentChecking = studentCheckingRepository.findById(transferDTO.getReceivingAccount());
        if(!optionalChecking.isPresent() && !optionalCreditCard.isPresent() && !optionalSavings.isPresent() && !optionalStudentChecking.isPresent() ){
            throw new IllegalArgumentException("Receiving account does not exist!!");
        }
        Optional<Checking> checkingOptional = checkingRepository.findById(transferDTO.getSendingAccount());
        Optional<CreditCard> creditCardOptional = creditCardRepository.findById(transferDTO.getSendingAccount());
        Optional<Savings> savingsOptional = savingsRepository.findById(transferDTO.getSendingAccount());
        Optional<StudentChecking> studentCheckingOptional = studentCheckingRepository.findById(transferDTO.getSendingAccount());
        if(!checkingOptional.isPresent() && !creditCardOptional.isPresent() && !savingsOptional.isPresent() && !studentCheckingOptional.isPresent() ){
            throw new IllegalArgumentException("Origin account does not exist!!");
        }

        if(optionalChecking.isPresent()){
            Checking receivingAccount = optionalChecking.get();
            Money newBalance = new Money(receivingAccount.getBalance().increaseAmount(new Money(transferDTO.getTransferAmount())));
            receivingAccount.setBalance(newBalance);
            checkingRepository.save(receivingAccount);

            System.out.println("\nThe account " + receivingAccount.getAccountNumber() +" from " + receivingAccount.getPrimaryOwner() + " has been credited successfully with: "+ transferDTO +"$, and shows now the following balance: "+ receivingAccount.getBalance());

        } else if(optionalCreditCard.isPresent()){
            CreditCard receivingAccount = optionalCreditCard.get();
            Money newBalance = new Money(receivingAccount.getBalance().increaseAmount(new Money(transferDTO.getTransferAmount())));
            receivingAccount.setBalance(newBalance);
            creditCardRepository.save(receivingAccount);
            System.out.println("\nThe account " + receivingAccount.getAccountNumber() +" from " + receivingAccount.getPrimaryOwner() + " has been credited successfully with: "+ transferDTO +"$, and shows now the following balance: "+ receivingAccount.getBalance());

        } else if(optionalSavings.isPresent()){
            Savings receivingAccount = optionalSavings.get();
            Money newBalance = new Money(receivingAccount.getBalance().increaseAmount(new Money(transferDTO.getTransferAmount())));
            receivingAccount.setBalance(newBalance);
            savingsRepository.save(receivingAccount);
            System.out.println("\nThe account " + receivingAccount.getAccountNumber() +" from " + receivingAccount.getPrimaryOwner() + " has been credited successfully with: "+ transferDTO +"$, and shows now the following balance: "+ receivingAccount.getBalance());
        } else if(optionalStudentChecking.isPresent()){
            StudentChecking receivingAccount = optionalStudentChecking.get();
            Money newBalance = new Money(receivingAccount.getBalance().increaseAmount(new Money(transferDTO.getTransferAmount())));
            receivingAccount.setBalance(newBalance);
            studentCheckingRepository.save(receivingAccount);
            System.out.println("\nThe account " + receivingAccount.getAccountNumber() +" from " + receivingAccount.getPrimaryOwner() + " has been credited successfully with: "+ transferDTO +"$, and shows now the following balance: "+ receivingAccount.getBalance());
        }
        if(checkingOptional.isPresent()){
            Checking myAccount = checkingOptional.get();
            if(myAccount.getBalance().getAmount().compareTo(transferDTO.getTransferAmount()) < 0){
                throw new IllegalArgumentException("insufficient funds");
            }
            Money newBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(transferDTO.getTransferAmount())));
            myAccount.setBalance( newBalance);

            if(myAccount.getBalance().getAmount().compareTo(new Money(new BigDecimal(250)).getAmount()) < 0){
                Money newPenalisedBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(new BigDecimal(40))));
                myAccount.setBalance(newPenalisedBalance);
            }
            checkingRepository.save(myAccount);
            System.out.println("The transfer has been realized with the amount of: " + transferDTO + " from the account of: " + myAccount.getPrimaryOwner()  + " with the account number: " + myAccount.getAccountNumber() +  " with the remaining balance of: " + myAccount.getBalance());
        }
        if(creditCardOptional.isPresent()){
            CreditCard myAccount = creditCardOptional.get();
            if(myAccount.getBalance().getAmount().compareTo(transferDTO.getTransferAmount()) < 0){
                throw new IllegalArgumentException("insufficient funds");
            }
            Money newBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(transferDTO.getTransferAmount())));
            myAccount.setBalance( newBalance);
            if(myAccount.getBalance().getAmount().compareTo(new Money(new BigDecimal(250)).getAmount()) < 0){
                Money newPenalisedBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(new BigDecimal(40))));
                myAccount.setBalance(newPenalisedBalance);
            }
            creditCardRepository.save(myAccount);
            System.out.println("The transfer has been realized with the amount of: " + transferDTO + " from the account of: " + myAccount.getPrimaryOwner()  + " with the account number: " + myAccount.getAccountNumber() +  " with the remaining balance of: " + myAccount.getBalance());
        }
        if(savingsOptional.isPresent()){
            Savings myAccount = savingsOptional.get();
            if(myAccount.getBalance().getAmount().compareTo(transferDTO.getTransferAmount()) < 0){
                throw new IllegalArgumentException("insufficient funds");
            }
            Money newBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(transferDTO.getTransferAmount())));
            myAccount.setBalance( newBalance);
            if(myAccount.getBalance().getAmount().compareTo(new Money(new BigDecimal(250)).getAmount()) < 0){
                Money newPenalisedBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(new BigDecimal(40))));
                myAccount.setBalance(newPenalisedBalance);
            }
            savingsRepository.save(myAccount);
            System.out.println("The transfer has been realized with the amount of: " + transferDTO + " from the account of: " + myAccount.getPrimaryOwner()  + " with the account number: " + myAccount.getAccountNumber() +  " with the remaining balance of: " + myAccount.getBalance());
        }

        if(studentCheckingOptional.isPresent()){
            StudentChecking myAccount = studentCheckingOptional.get();
            if(myAccount.getBalance().getAmount().compareTo(transferDTO.getTransferAmount()) < 0){
                throw new IllegalArgumentException("insufficient funds");
            }
            Money newBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(transferDTO.getTransferAmount())));
            myAccount.setBalance( newBalance);
            if(myAccount.getBalance().getAmount().compareTo(new Money(new BigDecimal(250)).getAmount()) < 0){
                Money newPenalisedBalance = new Money(myAccount.getBalance().decreaseAmount(new Money(new BigDecimal(40))));
                myAccount.setBalance(newPenalisedBalance);
            }
            studentCheckingRepository.save(myAccount);
            System.out.println("The transfer has been realized with the amount of: " + transferDTO + " from the account of: " + myAccount.getPrimaryOwner()  + " with the account number: " + myAccount.getAccountNumber() +  " with the remaining balance of: " + myAccount.getBalance());
        }

        return null;
    }


    @Override
    public void addFunds(Long accountId, DepositDTO depositDTO) {
        Optional<Checking> optionalChecking = checkingRepository.findById(accountId);
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(accountId);
        Optional<Savings> optionalSavings = savingsRepository.findById(accountId);
        Optional<StudentChecking> optionalStudentChecking = studentCheckingRepository.findById(accountId);

        if (optionalChecking.isPresent()){
            Checking account = optionalChecking.get();
            Money newBalance = new Money(account.getBalance().increaseAmount(new Money(depositDTO.getAmount().getAmount())));
            account.setBalance( newBalance);
            checkingRepository.save(optionalChecking.get());
        } else if (optionalCreditCard.isPresent()){
            CreditCard account = optionalCreditCard.get();
            Money newBalance = new Money(account.getBalance().increaseAmount(new Money(depositDTO.getAmount().getAmount())));
            account.setBalance( newBalance);
            creditCardRepository.save(optionalCreditCard.get());
        } else if (optionalSavings.isPresent()){
            Savings account = optionalSavings.get();
            Money newBalance = new Money(account.getBalance().increaseAmount(new Money(depositDTO.getAmount().getAmount())));
            account.setBalance( newBalance);
            savingsRepository.save(optionalSavings.get());
        } else if (optionalStudentChecking.isPresent()){
            StudentChecking account = optionalStudentChecking.get();
            Money newBalance = new Money(account.getBalance().increaseAmount(new Money(depositDTO.getAmount().getAmount())));
            account.setBalance( newBalance);
            studentCheckingRepository.save(optionalStudentChecking.get());
        }
        else {
            System.out.println("The account " + depositDTO.getAccountId() + " does not exist. \nBetter luck next time :)" );
        }
    }

    @Override
    public void withdrawFunds(Long accountId, WithdrawDTO withdrawDTO) {
        Optional<Checking> optionalChecking = checkingRepository.findById(accountId);
        Optional<CreditCard> optionalCreditCard = creditCardRepository.findById(accountId);
        Optional<Savings> optionalSavings = savingsRepository.findById(accountId);
        Optional<StudentChecking> optionalStudentChecking = studentCheckingRepository.findById(accountId);

        if (optionalChecking.isPresent()){
            Checking account = optionalChecking.get();
            Money newBalance = new Money(account.getBalance().decreaseAmount(new Money(withdrawDTO.getAmount().getAmount())));
            account.setBalance( newBalance);
            checkingRepository.save(optionalChecking.get());
        } else if (optionalCreditCard.isPresent()){
            CreditCard account = optionalCreditCard.get();
            Money newBalance = new Money(account.getBalance().decreaseAmount(new Money(withdrawDTO.getAmount().getAmount())));
            account.setBalance( newBalance);
            creditCardRepository.save(optionalCreditCard.get());
        } else if (optionalSavings.isPresent()){
            Savings account = optionalSavings.get();
            Money newBalance = new Money(account.getBalance().decreaseAmount(new Money(withdrawDTO.getAmount().getAmount())));
            account.setBalance( newBalance);
            savingsRepository.save(optionalSavings.get());
        } else if (optionalStudentChecking.isPresent()){
            StudentChecking account = optionalStudentChecking.get();
            Money newBalance = new Money(account.getBalance().decreaseAmount(new Money(withdrawDTO.getAmount().getAmount())));
            account.setBalance( newBalance);
            studentCheckingRepository.save(optionalStudentChecking.get());
        }
        else {
            System.out.println("The account " + withdrawDTO.getAccountId() + " does not exist. \nYou still sit tight on your money :)" );
        }
    }
}
       /* else if (optionalChecking.isPresent()) {
            optionalChecking.get().setBalance(new Money(depositDTO.getAmount()));
            checkingRepository.save(optionalChecking.get());
        } else if (optionalStudentChecking.isPresent()) {
            optionalStudentChecking.get().setBalance(new Money(depositDTO.getAmount()));
            studentCheckingRepository.save(optionalStudentChecking.get());
        } else if (optionalCreditCard.isPresent()){
            optionalCreditCard.get().setBalance(new Money(depositDTO.getAmount()));
            creditCardRepository.save(optionalCreditCard.get());
        }*/
