package com.fundamentals.springboot.fundamentals.controller;

import com.fundamentals.springboot.fundamentals.caseuse.GetUser;
import com.fundamentals.springboot.fundamentals.entity.User;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private GetUser getUser;

    public UserRestController(GetUser getUser) {
        this.getUser = getUser;
    }

    //create

    //get
    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }

    //delete

    //update

}
