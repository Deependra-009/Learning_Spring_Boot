package com.api.redis.controller;

import com.api.redis.models.User;
import com.api.redis.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("/user/save")
    public User addUser(@RequestBody User user){
        return userRepository.saveUser(user);
    }

    @PostMapping("/user/get/{id}")
    public User getUser(@PathVariable String id){
        return userRepository.getUser(id);
    }

    @PostMapping("/user/delete/{id}")
    public String deleteUser(@PathVariable String id){
        userRepository.delete(id);
        return "Successfully Deleted";

    }

    @PostMapping("/user/get-all")
    public Map<Object, Object> getAll(){
        return userRepository.getAll();
    }



}
