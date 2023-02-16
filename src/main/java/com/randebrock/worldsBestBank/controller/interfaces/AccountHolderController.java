package com.randebrock.worldsBestBank.controller.interfaces;

import com.randebrock.worldsBestBank.model.AccountHolder;

import java.util.List;

public interface AccountHolderController {
    List<AccountHolder> getUsers();
    void saveUser(AccountHolder user);
}
