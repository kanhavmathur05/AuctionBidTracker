package com.auctionbidtracker.service;

import com.auctionbidtracker.dto.UsersDTO;
import com.auctionbidtracker.entities.Users;


public interface UsersService {
    UsersDTO addUser(UsersDTO usersDTO);

    UsersDTO getUserById(int userId);
}
