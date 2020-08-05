package com.auctionbidtracker.service.impl;

import com.auctionbidtracker.dto.UsersDTO;
import com.auctionbidtracker.mapper.UsersMapper;
import com.auctionbidtracker.entities.Users;
import com.auctionbidtracker.repository.UsersRepository;
import com.auctionbidtracker.service.UsersService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UsersServiceImpl implements UsersService {

    @Autowired
    UsersRepository usersRepository;

    @Autowired
    UsersMapper usersMapper;

    @Override
    public UsersDTO addUser(UsersDTO usersDTO) {
        Users users = usersMapper.toEntity(usersDTO);
        usersDTO = usersMapper.toDTO(usersRepository.save(users));
        return usersDTO;
    }

    @Override
    public Users getUserById(int userId) {
        return usersRepository.findById(userId).get();
    }
}
