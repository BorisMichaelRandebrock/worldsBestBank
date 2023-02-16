package com.randebrock.worldsBestBank.service.impl;

import com.randebrock.worldsBestBank.controller.dto.CheckingDTO;
import com.randebrock.worldsBestBank.controller.dto.CreditCardDTO;
import com.randebrock.worldsBestBank.controller.dto.SavingsDTO;
import com.randebrock.worldsBestBank.controller.dto.StudentCheckingDTO;
import com.randebrock.worldsBestBank.model.*;
import com.randebrock.worldsBestBank.repository.*;
import com.randebrock.worldsBestBank.service.interfaces.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class AdminServiceImpl implements AdminService {
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

    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private AdminRepository adminRepository;

    @Override
    public List<Checking> getAllCheckingAccounts() {
        return checkingRepository.findAll();
    }

    @Override
    public List<CreditCard> getAllCreditCardAccounts() {
        return creditCardRepository.findAll();
    }

    @Override
    public List<Savings> getAllSavingsAccounts() {
        return savingsRepository.findAll();
    }

    @Override
    public List<StudentChecking> getAllStudentCheckingAccounts() {
        return studentCheckingRepository.findAll();
    }

    @Override
    public Checking createNewCheckingAccount(CheckingDTO checkingDTO) {
        Optional<AccountHolder> optionalAccountHolder = accountHolderRepository.findById(checkingDTO.getPrimaryOwner().getId());
       if(!optionalAccountHolder.isPresent()) {
           throw new IllegalArgumentException("Primary owner does not exist in database...!");
       }
           Checking account = new Checking(optionalAccountHolder.get(),checkingDTO.getOptionalSecondaryOwner() ,checkingDTO.getSecretKey());
            /*account.setAccountNumber(checkingDTO.getAccountNumber());
            account.setBalance(checkingDTO.getBalance());
            account.setPrimaryOwner(checkingDTO.getPrimaryOwner());
            account.setOptionalSecondaryOwner(checkingDTO.getOptionalSecondaryOwner());
            account.setSecretKey(checkingDTO.getSecretKey());*/
          checkingRepository.save(account);
           return account;
    }

    @Override
    public CreditCard createNewCreditCardAccount(CreditCardDTO creditCardDTO) {
        Optional<AccountHolder> optionalAccountHolder = accountHolderRepository.findById(creditCardDTO.getPrimaryOwner().getId());
        if(!optionalAccountHolder.isPresent()) {
            throw new IllegalArgumentException("Primary owner does not exist in database...!");
        }
        CreditCard account = new CreditCard(optionalAccountHolder.get(), creditCardDTO.getOptionalSecondaryOwner());
      /*  account.setAccountNumber(creditCardDTO.getAccountNumber());
        account.setBalance(creditCardDTO.getBalance());
        account.setPrimaryOwner(creditCardDTO.getPrimaryOwner());
        account.setOptionalSecondaryOwner(creditCardDTO.getOptionalSecondaryOwner());
        account.setPenaltyFee(creditCardDTO.getPenaltyFee());
        account.setCreditLimit(creditCardDTO.getCreditLimit());
//        account.setCreationDate(creditCardDTO.getCreationDate());
        account.setInterestRate(creditCardDTO.getInterestRate());
*/
        creditCardRepository.save(account);
        return account;
    }

    @Override
    public Savings createNewSavingsAccount(SavingsDTO savingsDTO) {
        Optional<AccountHolder> optionalAccountHolder = accountHolderRepository.findById(savingsDTO.getPrimaryOwner().getId());
        if(!optionalAccountHolder.isPresent()) {
            throw new IllegalArgumentException("Primary owner does not exist in database...!");
        }
        Savings account = new Savings(optionalAccountHolder.get(), savingsDTO.getOptionalSecondaryOwner(), savingsDTO.getSecretKey());
        savingsRepository.save(account);
        return account;
    }

    @Override
    public StudentChecking createNewStudentsCheckingAccount(StudentCheckingDTO studentCheckingDTO) {
        Optional<AccountHolder> optionalAccountHolder = accountHolderRepository.findById(studentCheckingDTO.getPrimaryOwner().getId());
        if(!optionalAccountHolder.isPresent()) {
            throw new IllegalArgumentException("Primary owner does not exist in database...!");
        }
        StudentChecking account = new StudentChecking(optionalAccountHolder.get(),studentCheckingDTO.getOptionalSecondaryOwner(),studentCheckingDTO.getSecretKey());
        studentCheckingRepository.save(account);
        return account;
    }

    public Admin addAdmin(Admin admin) {
        admin.setPassword(passwordEncoder.encode(admin.getPassword()));
        return adminRepository.save(admin);
    }
}
