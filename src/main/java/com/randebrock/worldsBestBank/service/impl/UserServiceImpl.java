package com.randebrock.worldsBestBank.service.impl;

import com.randebrock.worldsBestBank.model.AccountHolder;
import com.randebrock.worldsBestBank.repository.AccountHolderRepository;
import com.randebrock.worldsBestBank.repository.UserRepository;
import com.randebrock.worldsBestBank.service.interfaces.UserService;
import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private AccountHolderRepository accountHolderRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public AccountHolder saveUser(AccountHolder user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return accountHolderRepository.save(user);
    }

    @Override
    public List<AccountHolder> getUsers() {
        return accountHolderRepository.findAll();
    }
}