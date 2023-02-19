package com.randebrock.worldsBestBank.service.interfaces;

import com.randebrock.worldsBestBank.controller.dto.DepositDTO;
import com.randebrock.worldsBestBank.controller.dto.TransferDTO;
import com.randebrock.worldsBestBank.model.AccountHolder;
import com.randebrock.worldsBestBank.model.Transfer;

import java.util.List;

public interface AccountHolderService {
    List<AccountHolder> getUsers();
    AccountHolder addAccountHolder(AccountHolder accountHolder);

    Transfer makeTransfer(TransferDTO transferDTO);

    void addFunds(Long accountId, DepositDTO depositDTO);
}
