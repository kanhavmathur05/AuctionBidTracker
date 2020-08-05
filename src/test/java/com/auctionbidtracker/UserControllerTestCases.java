package com.auctionbidtracker;

import com.auctionbidtracker.dto.UsersDTO;
import com.auctionbidtracker.service.UsersService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class UserControllerTestCases {

    @Autowired
    private UsersService usersService;

    Logger logger = LoggerFactory.getLogger(UserControllerTestCases.class);

    @Test
    public void saveUser() {
        UsersDTO usersDTO = new UsersDTO();
        usersDTO.setUserName("Mark");
        usersDTO.setAccountBalance(300000);
        UsersDTO result = usersService.addUser(usersDTO);

        logger.info("id->" + result.getId());
        logger.info("userName->" + result.getUserName());
        logger.info("accountBalance->" + result.getAccountBalance());
    }

}
