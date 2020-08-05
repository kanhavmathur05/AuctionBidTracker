package com.auctionbidtracker.repository;

import com.auctionbidtracker.entities.Challenge;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ChallengeRepository extends CrudRepository<Challenge, Integer> {
}
