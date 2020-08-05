package com.auctionbidtracker.service;

import com.auctionbidtracker.dto.BidDTO;
import com.auctionbidtracker.entities.Bid;
import com.auctionbidtracker.vm.ItemVm;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface BidService {
    Page<Bid> getAllBidsForItem(int itemId, Pageable pageable);

    BidDTO saveBidForItem(BidDTO bidDTO);

    List<Bid> getBidsListByUserId(int userId);

    ItemVm getWinningBid(int itemId);
}
