package com.randebrock.worldsBestBank.service.interfaces;

import com.randebrock.worldsBestBank.controller.dto.CheckingDTO;
import com.randebrock.worldsBestBank.controller.dto.CreditCardDTO;
import com.randebrock.worldsBestBank.controller.dto.SavingsDTO;
import com.randebrock.worldsBestBank.controller.dto.StudentCheckingDTO;
import com.randebrock.worldsBestBank.model.*;

import java.util.List;

public interface AdminService {
    List<Checking> getAllCheckingAccounts();
    List<CreditCard> getAllCreditCardAccounts();
    List<Savings> getAllSavingsAccounts();
    List<StudentChecking> getAllStudentCheckingAccounts();

    Checking createNewCheckingAccount(CheckingDTO checkingDTO);
    CreditCard createNewCreditCardAccount(CreditCardDTO creditCardDTO);
    Savings createNewSavingsAccount(SavingsDTO savingsDTO);
    StudentChecking createNewStudentsCheckingAccount(StudentCheckingDTO studentCheckingDTO);


    Admin addAdmin(Admin admin);

}
