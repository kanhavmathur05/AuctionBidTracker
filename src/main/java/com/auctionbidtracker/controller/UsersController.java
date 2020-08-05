package com.auctionbidtracker.controller;

import com.auctionbidtracker.dto.UsersDTO;
import com.auctionbidtracker.service.UsersService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UsersController {

    @Autowired
    UsersService usersService;

    Logger logger = LoggerFactory.getLogger(UsersController.class);

    @ApiOperation("This API is used to save user details.")
    @PostMapping("/save-user")
    public ResponseEntity<UsersDTO> saveUser(@RequestBody UsersDTO usersDTO) {
        UsersDTO resultBody = usersService.addUser(usersDTO);
        return ResponseEntity.status(HttpStatus.OK).body(resultBody);
    }
}
