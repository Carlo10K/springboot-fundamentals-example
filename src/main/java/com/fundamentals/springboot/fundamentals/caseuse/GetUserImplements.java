package com.fundamentals.springboot.fundamentals.caseuse;

import com.fundamentals.springboot.fundamentals.entity.User;
import com.fundamentals.springboot.fundamentals.service.UserService;

import java.util.List;

public class GetUserImplements implements GetUser{
    private UserService userService;

    public GetUserImplements(UserService userService) {
        this.userService = userService;
    }

    @Override
    public List<User> getAll() {
        return userService.getAllUsers();
    }
}
