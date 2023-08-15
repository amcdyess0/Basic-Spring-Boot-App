package com.website.website.controller;

import com.website.website.model.User;
import com.website.website.repository.Repository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class Controller {

    @Autowired
    private Repository repository;

    @PostMapping("/postUser")
    public User postUser(@RequestBody User user){
        user.setId(new ObjectId());
        user.setUserId(user.getId().toString());
        repository.save(user);
        return user;
    }

    @PostMapping("/postUserList")
    public List<User> postUserList(@RequestBody List<User> users){
        for(User user : users){
            user.setId(new ObjectId());
            user.setUserId(user.getId().toString());
            repository.save(user);
        }
        return users;
    }

    @GetMapping("/getUser")
    public Optional<User> getUser(@RequestBody User user){
        return repository.findById(user.getUserId());
    }

    @GetMapping("/getAllUsers")
    public List<User> getAllUsers(){
        return repository.findAll();
    }

    @PutMapping("/putUser")
    public User putUser(@RequestBody User user){
        User update = repository.findById(user.getUserId())
                .orElseThrow(() -> new RuntimeException("User id: " + user.getUserId() + "does not exist"));

        if(user.getContactDetails() != null) {
            update.setContactDetails(user.getContactDetails());
        }
        if(user.getPersonalInfo() != null) {
            update.setPersonalInfo(user.getPersonalInfo());
        }
        if(user.getAccountInfo() != null) {
            update.setAccountInfo(user.getAccountInfo());
        }

        repository.save(update);

        return update;
    }

    @DeleteMapping("/deleteUser")
    public String deleteUser(@RequestBody User user){
        String id = user.getUserId();
        repository.deleteById(user.getUserId());
        return "User with id: " + id + " has been deleted.";
    }

    @DeleteMapping("/deleteAll")
    public String deleteAll(){
        int num = repository.findAll().size();
        repository.deleteAll();
        return num + " users were deleted";
    }
}
