package com.auctionbidtracker.service;

import com.auctionbidtracker.models.Users;


public interface UsersService {
    Users addUser(Users user);

    Users getUserById(int userId);
}
