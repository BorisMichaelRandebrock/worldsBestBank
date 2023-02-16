package com.randebrock.worldsBestBank.service.impl;

//import com.randebrock.worldsBestBank.controller.dto.TransferDTO;
import com.randebrock.worldsBestBank.model.AccountHolder;
//import com.randebrock.worldsBestBank.model.Transfer;
import com.randebrock.worldsBestBank.repository.AccountHolderRepository;
import com.randebrock.worldsBestBank.service.interfaces.AccountHolderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AccountHolderImpl implements AccountHolderService {
    @Autowired
    private AccountHolderRepository accountHolderRepository;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public List<AccountHolder> getUsers() {
        return accountHolderRepository.findAll();
    }

    public AccountHolder addAccountHolder(AccountHolder accountHolder) {
        accountHolder.setPassword(passwordEncoder.encode(accountHolder.getPassword()));
        return accountHolderRepository.save(accountHolder);
    }

   /* @Override
    public Transfer makeTransfer(TransferDTO transferDTO) {*/
        /*
        * user is owner of sending account
        * transfer dto:
        *   sending acc id
        *   receivingacc id
        *   amount
        * -----------
        * jpa method checking 4 finding user acc matching owner repositorio cuentas account
        * findByownerIDAccountId
        * find balance else error
        * if ok send
        * if enough but below minimum -> penalty fee--
        *
        *
        *
        *
        * */
    /*    return null;
    }*/
}
