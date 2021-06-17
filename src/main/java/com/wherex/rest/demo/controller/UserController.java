package com.wherex.rest.demo.controller;

import com.wherex.rest.demo.model.User;
import com.wherex.rest.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/users")
public class UserController {
    
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    @RequestMapping("/{login}")
    public User getUser(@PathVariable("login") String login){
       return userService.getUser(login);
    }
}
