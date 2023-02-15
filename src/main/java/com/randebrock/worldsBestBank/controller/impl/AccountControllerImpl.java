package com.randebrock.worldsBestBank.controller.impl;

import com.randebrock.worldsBestBank.controller.dto.CheckingDTO;
import com.randebrock.worldsBestBank.controller.interfaces.AccountController;
import com.randebrock.worldsBestBank.model.Checking;
import com.randebrock.worldsBestBank.model.User;
import com.randebrock.worldsBestBank.service.interfaces.AccountService;
import com.randebrock.worldsBestBank.service.interfaces.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AccountControllerImpl implements AccountController {
    @Autowired
    private AccountService accountService;
//    @PostMapping("/accounts")
//    @ResponseStatus(HttpStatus.CREATED)
//    public void createNewAccount(@RequestBody User user) {
//        accountService.createNewAccount();
//    }



    @PostMapping("/accounts/checkings")
    @ResponseStatus(HttpStatus.CREATED)
    public void createNewCheckingAccount(@RequestBody @Valid CheckingDTO checkingDTO) {
        accountService.createNewCheckingAccount(checkingDTO);
    }
}
