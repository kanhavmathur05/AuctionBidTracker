package com.auctionbidtracker.service.impl;

import com.auctionbidtracker.dto.BidDTO;
import com.auctionbidtracker.entities.Bid;
import com.auctionbidtracker.entities.Users;
import com.auctionbidtracker.mapper.BidMapper;
import com.auctionbidtracker.mapper.UsersMapper;
import com.auctionbidtracker.repository.BidRepository;
import com.auctionbidtracker.service.BidService;
import com.auctionbidtracker.service.UsersService;
import com.auctionbidtracker.vm.ItemVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.TreeSet;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    BidMapper bidMapper;

    @Autowired
    BidRepository bidRepository;

    @Autowired
    UsersService usersService;

    @Autowired
    UsersMapper usersMapper;

    @Override
    public Page<Bid> getAllBidsForItem(int itemId, Pageable pageable) {
        Page<Bid> bidList = bidRepository.findAllByItemIdOrderByBidPriceDesc(itemId, pageable);
        return bidList;
    }

    @Override
    public BidDTO saveBidForItem(BidDTO bidDTO) {
        try {
            Bid bid = bidMapper.toEntity(bidDTO);
            List<Bid> bidList = bidRepository.findAllByItemIdOrderByBidPriceDesc(bid.getItemId());
            if (!bidList.isEmpty()) {
                if (bid.getBidPrice() <= bidList.get(0).getBidPrice()) {
                    throw new Exception("Current Bid Value is less than the last heighest bid Value");
                } else {
                    bid = bidRepository.save(bid);
                    bidDTO = bidMapper.toDTO(bid);
                }
            } else {
                bid = bidRepository.save(bid);
                bidDTO = bidMapper.toDTO(bid);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bidDTO;
    }

    @Override
    public List<Bid> getBidsListByUserId(int userId) {
        List<Bid> bidList = new ArrayList<>();
        try {
            bidList = bidRepository.findAllByUserId(userId);
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return bidList;
    }

    @Override
    public ItemVm getWinningBid(int itemId) {
        ItemVm itemVm = new ItemVm();
        List<Bid> bidList = new ArrayList<>();
        try {
            bidList = bidRepository.findAllByItemIdOrderByBidPriceDesc(itemId);
            if (!bidList.isEmpty()) {
                Bid bid = bidList.get(0);
                Users users = usersMapper.toEntity(usersService.getUserById(bid.getUserId()));
                itemVm.setUsers(users);
                itemVm.setBidId(bid.getId());
                itemVm.setBidPrice(bid.getBidPrice());
                itemVm.setItemId(bid.getItemId());
            } else {
                return null;
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return itemVm;
    }
}
