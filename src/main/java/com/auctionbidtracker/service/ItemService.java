package com.auctionbidtracker.service;

import com.auctionbidtracker.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    List<ItemDTO> getItemsList(int userId);
}