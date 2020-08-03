package com.auctionbidtracker.controller;

import com.auctionbidtracker.models.Bid;
import com.auctionbidtracker.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class BidController {

    @Autowired
    BidService bidService;

    @GetMapping("/get-bids/{itemId}")
    public Page<Bid> getBidsForItem(@PathVariable int itemId, Pageable pageable) {
        return bidService.getAllBidsForItem(itemId,pageable);
    }
}
