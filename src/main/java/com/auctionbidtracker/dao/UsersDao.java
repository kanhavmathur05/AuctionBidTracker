package com.auctionbidtracker.dao;

import com.auctionbidtracker.models.Users;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsersDao extends CrudRepository<Users, Integer> {
}
