package com.auctionbidtracker.controller;

import com.auctionbidtracker.dto.BidDTO;
import com.auctionbidtracker.models.Bid;
import com.auctionbidtracker.service.BidService;
import com.auctionbidtracker.vm.ItemVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BidController {

    @Autowired
    BidService bidService;

    @GetMapping("/get-bids/{itemId}")
    public Page<Bid> getBidsForItem(@PathVariable int itemId, Pageable pageable) {
        Bid b = new Bid();
        return bidService.getAllBidsForItem(itemId, pageable);
    }

    @PostMapping("/save-bid")
    public void saveBid(@RequestBody BidDTO bidDTO) {
        bidService.saveBidForItem(bidDTO);
    }

    @GetMapping("/get-winning-bid/{itemId}")
    public ItemVm getWinningBid(@PathVariable int itemId) {
        return bidService.getWinningBid(itemId);
    }
}
