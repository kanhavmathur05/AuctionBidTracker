package com.auctionbidtracker.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class ChallengeController {
    Logger logger = LoggerFactory.getLogger(ChallengeController.class);
}
