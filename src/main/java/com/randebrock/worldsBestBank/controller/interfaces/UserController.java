package com.randebrock.worldsBestBank.controller.interfaces;

import com.randebrock.worldsBestBank.model.User;

import java.util.List;

public interface UserController {
    List<User> getUsers();
    void saveUser(User user);
}
