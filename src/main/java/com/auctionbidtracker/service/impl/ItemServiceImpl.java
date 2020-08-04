package com.auctionbidtracker.service.impl;


import com.auctionbidtracker.dao.ItemDao;
import com.auctionbidtracker.dto.ItemDTO;
import com.auctionbidtracker.mapper.ItemMapper;
import com.auctionbidtracker.models.Bid;
import com.auctionbidtracker.models.Item;
import com.auctionbidtracker.service.BidService;
import com.auctionbidtracker.service.ItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    ItemDao itemDao;

    @Autowired
    BidService bidService;

    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<ItemDTO> getItemsList(int userId) {
        List<ItemDTO> result;
        List<Bid> tempList = bidService.getBidsListByUserId(userId);
        TreeSet<Integer> itemSet = new TreeSet<>();
        for (Bid temp : tempList) {
            if (!itemSet.contains(temp.getItemId())) {
                itemSet.add(temp.getItemId());
            }
        }
        if (!itemSet.isEmpty()) {
            List<Item> tempResultItemList = new ArrayList<>();
            for (Integer itemId : itemSet) {
                tempResultItemList.add(itemDao.findById(itemId.intValue()).get());
            }
            result = itemMapper.toDTOList(tempResultItemList);
        } else {
            result = new ArrayList<>();
        }
        return result;
    }
}
