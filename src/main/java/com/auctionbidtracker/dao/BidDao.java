package com.auctionbidtracker.dao;

import com.auctionbidtracker.models.Bid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BidDao extends CrudRepository<Bid,Integer> {

    Page<Bid> findAllByItemId(int itemId, Pageable pageable);
}
