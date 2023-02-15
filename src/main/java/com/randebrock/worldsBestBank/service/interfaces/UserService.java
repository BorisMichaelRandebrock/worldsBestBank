package com.randebrock.worldsBestBank.service.interfaces;

import com.randebrock.worldsBestBank.model.AccountHolder;

import java.util.List;

public interface UserService {
    AccountHolder saveUser(AccountHolder accountHolder);
    List<AccountHolder> getUsers();
}
