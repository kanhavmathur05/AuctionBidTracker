package com.auctionbidtracker.controller;

import com.auctionbidtracker.models.Users;
import com.auctionbidtracker.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    UsersService usersService;

    @PostMapping()
    public Users saveUser(Users users) {
        return usersService.addUser(users);
    }
}
