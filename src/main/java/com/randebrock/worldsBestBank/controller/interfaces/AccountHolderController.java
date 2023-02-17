package com.randebrock.worldsBestBank.controller.interfaces;

import com.randebrock.worldsBestBank.controller.dto.TransferDTO;
import com.randebrock.worldsBestBank.model.AccountHolder;
import com.randebrock.worldsBestBank.model.Transfer;

import java.util.List;

public interface AccountHolderController {
    List<AccountHolder> getUsers();
    void saveUser(AccountHolder user);
//    Transfer moneyTransfer(TransferDTO transferDTO);
}
