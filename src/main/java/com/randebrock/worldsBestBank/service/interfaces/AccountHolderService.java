package com.randebrock.worldsBestBank.service.interfaces;

import com.randebrock.worldsBestBank.controller.dto.DepositDTO;
import com.randebrock.worldsBestBank.controller.dto.TransferDTO;
import com.randebrock.worldsBestBank.controller.dto.WithdrawDTO;
import com.randebrock.worldsBestBank.model.AccountHolder;
import com.randebrock.worldsBestBank.model.Address;
import com.randebrock.worldsBestBank.model.Transfer;

import java.util.List;

public interface AccountHolderService {
//    Address addAddress(String streetName, Integer houseNumber, String appartmentNumber, String city, Integer postCode, String country);
    AccountHolder addAccountHolder(AccountHolder accountHolder);
    List<AccountHolder> getUsers();

    Transfer makeTransfer(TransferDTO transferDTO);

    void addFunds(Long accountId, DepositDTO depositDTO);
    void withdrawFunds(Long accountId, WithdrawDTO withdrawDTO);
    void deleteAccount(Long accountNumber);
}
