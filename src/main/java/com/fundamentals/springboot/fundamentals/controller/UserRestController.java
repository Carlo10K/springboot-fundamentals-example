package com.fundamentals.springboot.fundamentals.controller;

import com.fundamentals.springboot.fundamentals.caseuse.CreateUser;
import com.fundamentals.springboot.fundamentals.caseuse.DeleteUser;
import com.fundamentals.springboot.fundamentals.caseuse.GetUser;
import com.fundamentals.springboot.fundamentals.caseuse.UpdateUser;
import com.fundamentals.springboot.fundamentals.entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserRestController {
    private final GetUser getUser;
    private final CreateUser createUser;

    private final DeleteUser deleteUser;
    private final UpdateUser updateUser;

    public UserRestController(GetUser getUser, CreateUser createUser, DeleteUser deleteUser, UpdateUser updateUser) {
        this.getUser = getUser;
        this.createUser = createUser;
        this.deleteUser = deleteUser;
        this.updateUser = updateUser;
    }

    //create
    @PostMapping("/")
    ResponseEntity<User> newUser(@RequestBody User newUser){
        return new ResponseEntity<>(createUser.save(newUser), HttpStatus.CREATED);
    }


    //get
    @GetMapping("/")
    List<User> get(){
        return getUser.getAll();
    }

    //delete
    @DeleteMapping("/{id}")
    ResponseEntity deleteUser(@PathVariable Long id){
        deleteUser.remove(id);
        return new ResponseEntity(HttpStatus.NO_CONTENT);
    }

    //update
    @PutMapping("/{id}")
    ResponseEntity<User> replaceUser(@RequestBody User newUser, @PathVariable Long id){
        return new ResponseEntity<>(updateUser.update(newUser, id),HttpStatus.OK);
    }
}
