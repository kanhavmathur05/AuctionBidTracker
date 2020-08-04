package com.auctionbidtracker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableAutoConfiguration
public class AuctionBidTrackerApplication {
    public static void main(String[] args) {
        SpringApplication.run(AuctionBidTrackerApplication.class, args);
    }
}
