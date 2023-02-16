package com.randebrock.worldsBestBank.controller.interfaces;

import com.randebrock.worldsBestBank.controller.dto.CheckingDTO;
import com.randebrock.worldsBestBank.controller.dto.CreditCardDTO;
import com.randebrock.worldsBestBank.controller.dto.SavingsDTO;
import com.randebrock.worldsBestBank.controller.dto.StudentCheckingDTO;
import com.randebrock.worldsBestBank.model.Checking;
import com.randebrock.worldsBestBank.model.CreditCard;
import com.randebrock.worldsBestBank.model.Savings;
import com.randebrock.worldsBestBank.model.StudentChecking;

import java.util.List;

public interface AdminController {
    List<Checking> getAllCheckingAccounts();
    List<CreditCard> getAllCreditCardAccounts();
    List<Savings> getAllSavingsAccounts();
    List<StudentChecking> getAllStudentCheckingAccounts();

    Checking createNewCheckingAccount(CheckingDTO checkingDTO);
    CreditCard createNewCreditCardAccount(CreditCardDTO creditCardDTO);
    Savings createNewSavingsAccount(SavingsDTO savingsDTO);

    StudentChecking createNewStudentsCheckingAccount(StudentCheckingDTO studentCheckingDTO);

}
/*

createAccountHolders
seeBalanceAccountHolder
modifyBalance
 */