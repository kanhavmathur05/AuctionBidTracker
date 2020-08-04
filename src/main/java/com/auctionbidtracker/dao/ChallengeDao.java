package com.auctionbidtracker.dao;

import com.auctionbidtracker.models.Challenge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeDao extends CrudRepository<Challenge, Integer> {
}
