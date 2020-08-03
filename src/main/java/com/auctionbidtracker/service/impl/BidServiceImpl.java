package com.auctionbidtracker.service.impl;

import com.auctionbidtracker.dao.BidDao;
import com.auctionbidtracker.models.Bid;
import com.auctionbidtracker.service.BidService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    BidDao bidDao;

    @Override
    public Page<Bid> getAllBidsForItem(int itemId, Pageable pageable) {
        return bidDao.findAllByItemId(itemId,pageable);
    }
}
