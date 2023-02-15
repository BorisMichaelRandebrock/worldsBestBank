package com.randebrock.worldsBestBank.service.impl;

import com.randebrock.worldsBestBank.controller.dto.CheckingDTO;
import com.randebrock.worldsBestBank.model.Checking;
import com.randebrock.worldsBestBank.repository.CheckingRepository;
import com.randebrock.worldsBestBank.service.interfaces.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AccountServiceImpl implements AccountService {
    @Autowired
    private CheckingRepository checkingRepository;
    @Override
    public Checking createNewCheckingAccount(CheckingDTO checkingDTO) {
        Checking account = new Checking();
        return account;
    }
}
