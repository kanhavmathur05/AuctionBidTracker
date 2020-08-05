package com.auctionbidtracker.service.impl;

import com.auctionbidtracker.dto.UsersDTO;
import com.auctionbidtracker.entities.Users;
import com.auctionbidtracker.mapper.UsersMapper;
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
        UsersDTO usersDTOResult = new UsersDTO();
        try {
            Users users = usersMapper.toEntity(usersDTO);
            usersDTOResult = usersMapper.toDTO(usersRepository.save(users));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usersDTOResult;
    }

    @Override
    public UsersDTO getUserById(int userId) {
        UsersDTO usersDTO = new UsersDTO();
        Users users;
        try {
            users = usersRepository.findById(userId).get();
            usersDTO = usersMapper.toDTO(users);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return usersDTO;
    }
}
