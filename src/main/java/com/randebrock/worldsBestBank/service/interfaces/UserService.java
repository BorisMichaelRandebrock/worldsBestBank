package com.randebrock.worldsBestBank.service.interfaces;

import com.randebrock.worldsBestBank.model.User;

import java.util.List;

public interface UserService {
    User saveUser(User user);
    List<User> getUsers();
}
