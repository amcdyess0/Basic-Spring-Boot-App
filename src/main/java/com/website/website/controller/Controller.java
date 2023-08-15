package com.website.website.controller;

import com.website.website.model.User;
import com.website.website.repository.Repository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class Controller {

    @Autowired
    private Repository repository;

    @PostMapping("/postUser")
    public User postUser(@RequestBody User user){
        repository.save(user);
        return user;
    }

    @GetMapping("/getUser")
    public User getUser(@RequestBody User user){
        user = repository.findById(user.getUserId())
                .orElseThrow(() -> new RuntimeException("id not found"));
        return user;
    }

    @PutMapping("/putUser")
    public User putUser(@RequestBody User user){
        User update = repository.findById(user.getUserId())
                .orElseThrow(() -> new RuntimeException("id not found"));

        if(user.getAccountInfo() != null){
            update.setAccountInfo(user.getAccountInfo());
        }
        if(user.getPersonalInfo() != null){
            update.setPersonalInfo(user.getPersonalInfo());
        }
        if(user.getContactDetails() != null){
            update.setContactDetails(user.getContactDetails());
        }
        repository.save(update);
        return update;
    }

    @DeleteMapping("deleteUser")
    public String deleteUser(@RequestBody User user){
        user = repository.findById(user.getUserId())
                .orElseThrow(() -> new RuntimeException("id not found"));
        repository.deleteById(user.getUserId());

        return "User with id: " + user.getId() + " has been deleted";
    }
}
