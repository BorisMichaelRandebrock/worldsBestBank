package com.randebrock.worldsBestBank.controller.interfaces;

import com.randebrock.worldsBestBank.model.AccountHolder;

import java.util.List;

public interface UserController {
    List<AccountHolder> getUsers();
    void saveUser(AccountHolder user);
}
