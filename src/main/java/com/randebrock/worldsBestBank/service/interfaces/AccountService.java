package com.randebrock.worldsBestBank.service.interfaces;

import com.randebrock.worldsBestBank.controller.dto.CheckingDTO;
import com.randebrock.worldsBestBank.model.Checking;

import java.util.Optional;

public interface AccountService {
    Checking createNewCheckingAccount(CheckingDTO checkingDTO);
}
