package com.auctionbidtracker.service.impl;

import com.auctionbidtracker.dao.UsersDao;
import com.auctionbidtracker.models.Users;
import com.auctionbidtracker.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersDao usersDao;

    @Override
    public Users addUser(Users user) {
        return usersDao.save(user);
    }
}
