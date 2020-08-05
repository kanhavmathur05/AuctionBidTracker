package com.auctionbidtracker.controller;

import com.auctionbidtracker.dto.BidDTO;
import com.auctionbidtracker.entities.Bid;
import com.auctionbidtracker.service.BidService;
import com.auctionbidtracker.vm.ItemVm;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class BidController {

    @Autowired
    BidService bidService;

    Logger logger= LoggerFactory.getLogger(BidController.class);

    @ApiOperation("This Api gets the track or list of bids on an item in auction.")
    @GetMapping("/get-bids/{itemId}")
    public ResponseEntity<Page<Bid>> getBidsForItem(@PathVariable int itemId, Pageable pageable) {
        Page<Bid> resultBody = bidService.getAllBidsForItem(itemId, pageable);
        return ResponseEntity.status(HttpStatus.OK).body(resultBody);
    }

    @ApiOperation("This API is used to bid on the item in an auction by the user.")
    @PostMapping("/save-bid")
    public ResponseEntity<BidDTO> saveBid(@RequestBody BidDTO bidDTO) {
        BidDTO resultBody = bidService.saveBidForItem(bidDTO);
        return ResponseEntity.status(HttpStatus.OK).body(resultBody);
    }

    @ApiOperation("This API is used to get the winning bid and the details of the respective user.")
    @GetMapping("/get-winning-bid/{itemId}")
    public ResponseEntity<ItemVm> getWinningBid(@PathVariable int itemId) {
        ItemVm resultBody = bidService.getWinningBid(itemId);
        return ResponseEntity.status(HttpStatus.OK).body(resultBody);
    }
}