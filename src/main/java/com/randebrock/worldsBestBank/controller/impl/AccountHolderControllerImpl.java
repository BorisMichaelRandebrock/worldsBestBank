package com.randebrock.worldsBestBank.controller.impl;

import com.randebrock.worldsBestBank.controller.dto.DepositDTO;
import com.randebrock.worldsBestBank.controller.dto.TransferDTO;
import com.randebrock.worldsBestBank.controller.dto.WithdrawDTO;
import com.randebrock.worldsBestBank.controller.interfaces.AccountHolderController;
import com.randebrock.worldsBestBank.model.AccountHolder;
import com.randebrock.worldsBestBank.model.Transfer;
import com.randebrock.worldsBestBank.service.interfaces.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AccountHolderControllerImpl implements AccountHolderController {

    @Autowired
    private AccountHolderService accountHolderService;


    @GetMapping("/users")
    public List<AccountHolder> getUsers() {
        return accountHolderService.getUsers();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(AccountHolder user) {
    }


    @PostMapping("/transfer")
    @ResponseStatus(HttpStatus.CREATED)
    public Transfer moneyTransfer(@RequestBody TransferDTO transferDTO){
       return accountHolderService.makeTransfer(transferDTO);
    }

    @PatchMapping("/deposit/{accountNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addFunds(@PathVariable(name = "accountNumber") Long accountNumber, @RequestBody DepositDTO depositDTO) {
        accountHolderService.addFunds(accountNumber, depositDTO);
    }

    @PatchMapping("/withdraw/{accountNumber}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void withdrawFunds(@PathVariable(name = "accountNumber") Long accountNumber, @RequestBody WithdrawDTO withdrawDTO) {
        accountHolderService.withdrawFunds(accountNumber, withdrawDTO);
    }
}

