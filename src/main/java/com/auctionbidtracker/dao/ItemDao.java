package com.auctionbidtracker.dao;

import com.auctionbidtracker.models.Item;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ItemDao extends CrudRepository<Item, Integer> {
}
