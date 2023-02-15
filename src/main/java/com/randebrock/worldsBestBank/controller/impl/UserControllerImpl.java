package com.randebrock.worldsBestBank.controller.impl;

import com.randebrock.worldsBestBank.controller.interfaces.UserController;
import com.randebrock.worldsBestBank.model.AccountHolder;
import com.randebrock.worldsBestBank.service.interfaces.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    private UserService userService;


    @GetMapping("/users")
    public List<AccountHolder> getUsers() {
        return userService.getUsers();
    }

    @PostMapping("/users")
    @ResponseStatus(HttpStatus.CREATED)
    public void saveUser(@RequestBody AccountHolder user) {
        userService.saveUser(user);
    }
}

