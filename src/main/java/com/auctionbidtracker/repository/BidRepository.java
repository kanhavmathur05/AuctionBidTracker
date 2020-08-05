package com.auctionbidtracker.repository;

import com.auctionbidtracker.entities.Bid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.TreeSet;

@Repository
public interface BidRepository extends CrudRepository<Bid, Integer> {

    Page<Bid> findAllByItemIdOrderByBidPriceDesc(int itemId, Pageable pageable);

    TreeSet<Bid> findAllByItemId(int itemId);

    List<Bid> findAllByUserId(int userId);

    List<Bid> findAllByItemIdOrderByBidPriceDesc(int itemId);
}
