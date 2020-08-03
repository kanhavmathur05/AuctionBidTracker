package com.auctionbidtracker.service;

import com.auctionbidtracker.models.Bid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface BidService {
    Page<Bid> getAllBidsForItem(int itemId, Pageable pageable);
}
