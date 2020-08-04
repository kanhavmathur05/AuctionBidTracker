package com.auctionbidtracker.dao;

import com.auctionbidtracker.models.Bid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.TreeSet;

@Repository
public interface BidDao extends CrudRepository<Bid, Integer> {

    Page<Bid> findAllByItemId(int itemId, Pageable pageable);

    TreeSet<Bid> findAllByItemId(int itemId);

    List<Bid> findAllByUserId(int userId);

    List<Bid> findAllByItemIdOrderByBidPriceDesc(int itemId);
}
