package com.auctionbidtracker.dao;

import com.auctionbidtracker.models.Model1;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface Model1Interface extends CrudRepository<Model1, Integer> {
}
