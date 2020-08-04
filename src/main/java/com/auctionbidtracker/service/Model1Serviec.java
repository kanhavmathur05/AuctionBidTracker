package com.auctionbidtracker.service;

import com.auctionbidtracker.dao.Model1Interface;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class Model1Serviec {

    @Autowired
    Model1Interface model1Interface;

    public String method101() {
        return "Method returns String";
    }
}
