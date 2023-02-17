package com.randebrock.worldsBestBank.controller.impl;

import com.randebrock.worldsBestBank.controller.dto.CheckingDTO;
import com.randebrock.worldsBestBank.controller.dto.CreditCardDTO;
import com.randebrock.worldsBestBank.controller.dto.SavingsDTO;
import com.randebrock.worldsBestBank.controller.dto.StudentCheckingDTO;
import com.randebrock.worldsBestBank.controller.interfaces.AdminController;
import com.randebrock.worldsBestBank.model.*;
import com.randebrock.worldsBestBank.repository.*;
import com.randebrock.worldsBestBank.service.interfaces.AccountHolderService;
import com.randebrock.worldsBestBank.service.interfaces.AdminService;
import com.randebrock.worldsBestBank.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/admin")
public class AdminControllerImpl implements AdminController {
    @Autowired
    private AdminService adminService;
    @Autowired
    private AdminRepository adminRepository;
    @Autowired
    private AccountHolderService accountHolderService;

    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private CheckingRepository checkingRepository;
    @Autowired
    private CreditCardRepository creditCardRepository;
    @Autowired
    private SavingsRepository savingsRepository;
    @Autowired
    private  StudentCheckingRepository studentCheckingRepository;


    @Autowired
    private UserService userService;


    @PostMapping("/admin/admin")
    @ResponseStatus(HttpStatus.CREATED)
    public Admin addNewAdmin(@RequestBody @Valid Admin admin){
        return  adminService.addAdmin(admin);
    }

    @PostMapping("/admin/account-holder")
    @ResponseStatus(HttpStatus.CREATED)
    public AccountHolder addNewAccountHolder(@RequestBody AccountHolder accountHolder) {
        return accountHolderService.addAccountHolder(accountHolder);
    }
    @GetMapping("/accounts/checkings")
    public List<Checking> getAllCheckingAccounts() {
        return adminService.getAllCheckingAccounts();
    }

    @PostMapping("/accounts/checkings")
    @ResponseStatus(HttpStatus.CREATED)
    public Checking createNewCheckingAccount(@RequestBody CheckingDTO checkingDTO) {
      return adminService.createNewCheckingAccount(checkingDTO);
    }

    @PostMapping("/accounts/credit-cards")
    public CreditCard createNewCreditCardAccount(@RequestBody CreditCardDTO creditCardDTO) {
      return adminService.createNewCreditCardAccount(creditCardDTO);
    }

    @PostMapping("/accounts/savings")
    public Savings createNewSavingsAccount(@RequestBody SavingsDTO savingsDTO) {
        return adminService.createNewSavingsAccount(savingsDTO);
    }

    @PostMapping("/accounts/student-checkings")
    public StudentChecking createNewStudentsCheckingAccount(@RequestBody StudentCheckingDTO studentCheckingDTO) {
        return adminService.createNewStudentsCheckingAccount(studentCheckingDTO);
    }

    @GetMapping("/accounts/checkings/{accountNumber}")
    public Checking findByAccountNumber(@PathVariable(name = "accountNumber") Long accountNumber) {
        return checkingRepository.findById(accountNumber).get();
    }

    @GetMapping("/accounts/credit-cards/{accountNumber}")
    public CreditCard findCreditCardByAccountNumber(@PathVariable(name = "accountNumber") Long accountNumber) {
        return creditCardRepository.findById(accountNumber).get();
    }

    @GetMapping("/accounts/savings/{accountNumber}")
    public Savings findSavingsByAccountNumber(@PathVariable(name = "accountNumber") Long accountNumber) {
            return savingsRepository.findById(accountNumber).get();
    }

    @GetMapping("/accounts/student-checkings/{accountNumber}")
    public StudentChecking findStudentCheckingByAccountNumber(@PathVariable(name = "accountNumber") Long accountNumber) {
        return studentCheckingRepository.findById(accountNumber).get();
    }

    @GetMapping("/accounts/credit-cards")
    public List<CreditCard> getAllCreditCardAccounts() {
        return adminService.getAllCreditCardAccounts();
    }

    @GetMapping("/accounts/savings")
    public List<Savings> getAllSavingsAccounts() { return  adminService.getAllSavingsAccounts();
    }

    @GetMapping("/accounts/student-checkings")
    public List<StudentChecking> getAllStudentCheckingAccounts() { return  adminService.getAllStudentCheckingAccounts();
    }


   /* @GetMapping("/accounts")
    public List<Account> getAllAccounts(){
                adminService.getAllCheckingAccounts();
                adminService.getAllSavingsAccounts();
                adminService.getAllCreditCardAccounts();
                adminService.getAllStudentCheckingAccounts();
        return
    }*/

}
