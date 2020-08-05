package com.auctionbidtracker.service.impl;


import com.auctionbidtracker.dto.ItemDTO;
import com.auctionbidtracker.entities.Bid;
import com.auctionbidtracker.entities.Item;
import com.auctionbidtracker.mapper.ItemMapper;
import com.auctionbidtracker.repository.ItemRepository;
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
    ItemRepository itemRepository;

    @Autowired
    BidService bidService;

    @Autowired
    ItemMapper itemMapper;

    @Override
    public List<ItemDTO> getItemsList(int userId) {
        List<ItemDTO> result = new ArrayList<>();
        TreeSet<Integer> itemSet = new TreeSet<>();
        try {
            List<Bid> tempList = bidService.getBidsListByUserId(userId);
            for (Bid temp : tempList) {
                if (!itemSet.contains(temp.getItemId())) {
                    itemSet.add(temp.getItemId());
                }
            }
            if (!itemSet.isEmpty()) {
                List<Item> tempResultItemList = new ArrayList<>();
                for (Integer itemId : itemSet) {
                    tempResultItemList.add(itemRepository.findById(itemId.intValue()).get());
                }
                result = itemMapper.toDTOList(tempResultItemList);
            } else {
                result = new ArrayList<>();
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return result;
    }

    @Override
    public ItemDTO createItem(ItemDTO itemDTO) {
        try {
            Item item = itemMapper.toEntity(itemDTO);
            itemDTO = itemMapper.toDTO(itemRepository.save(item));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemDTO;
    }
}
