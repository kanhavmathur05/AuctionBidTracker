package com.auctionbidtracker.service.impl;

import com.auctionbidtracker.dao.BidDao;
import com.auctionbidtracker.dto.BidDTO;
import com.auctionbidtracker.mapper.BidMapper;
import com.auctionbidtracker.mapper.UsersMapper;
import com.auctionbidtracker.models.Bid;
import com.auctionbidtracker.models.Users;
import com.auctionbidtracker.service.BidService;
import com.auctionbidtracker.service.UsersService;
import com.auctionbidtracker.vm.ItemVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.TreeSet;

@Service
public class BidServiceImpl implements BidService {

    @Autowired
    BidMapper bidMapper;

    @Autowired
    BidDao bidDao;

    @Autowired
    UsersService usersService;

    @Autowired
    UsersMapper usersMapper;

    @Override
    public Page<Bid> getAllBidsForItem(int itemId, Pageable pageable) {
        Page<Bid> temp = bidDao.findAllByItemId(itemId, pageable);
        //Page<BidDTO> bidList=bidMapper.toDTOList(temp);
        return temp;
    }

    @Override
    public BidDTO saveBidForItem(BidDTO bidDTO) {

        Bid bid = bidMapper.toEntity(bidDTO);
        TreeSet<Bid> bidList = bidDao.findAllByItemId(bid.getItemId());
        if (bid.getBidPrice() <= bidList.last().getBidPrice()) {
            //throw error
        } else {
            bidDTO = bidMapper.toDTO(bidDao.save(bid));
        }
        return bidDTO;
    }

    @Override
    public List<Bid> getBidsListByUserId(int userId) {
        List<Bid> bidList = bidDao.findAllByUserId(userId);
        return bidList;
    }

    @Override
    public ItemVm getWinningBid(int itemId) {
        ItemVm itemVm = new ItemVm();
        List<Bid> bidList = bidDao.findAllByItemIdOrderByBidPriceDesc(itemId);
        if (!bidList.isEmpty()) {
            Bid bid = bidList.get(0);
            Users users = usersService.getUserById(bid.getUserId());
            itemVm.setUsers(users);
            itemVm.setBidId(bid.getId());
            itemVm.setBidPrice(bid.getBidPrice());
            itemVm.setItemId(bid.getItemId());
            return itemVm;
        } else {
            return null;
        }
    }
}
