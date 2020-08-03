package com.auctionbidtracker.controller;

import com.auctionbidtracker.models.Model1;
import com.auctionbidtracker.dao.Model1Interface;
import com.auctionbidtracker.service.Model1Serviec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class HomeController {

    @Autowired
    Model1Serviec model1Serviec;
    @Autowired
    Model1Interface model1Interface;

    @GetMapping("/getText")
    public Model1 get() {
        Model1 m=new Model1();
        m.setName("sildjfli");
        return model1Interface.save(m);
    }
}
