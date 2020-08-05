package com.auctionbidtracker.service.impl;

import com.auctionbidtracker.dto.BidDTO;
import com.auctionbidtracker.mapper.BidMapper;
import com.auctionbidtracker.mapper.UsersMapper;
import com.auctionbidtracker.entities.Bid;
import com.auctionbidtracker.entities.Users;
import com.auctionbidtracker.repository.BidRepository;
import com.auctionbidtracker.service.BidService;
import com.auctionbidtracker.service.UsersService;
import com.auctionbidtracker.vm.ItemVm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

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
        Page<Bid> temp = bidRepository.findAllByItemIdOrderByBidPriceDesc(itemId, pageable);
        //Page<BidDTO> bidList=bidMapper.toDTOList(temp);
        return temp;
    }

    @Override
    public BidDTO saveBidForItem(BidDTO bidDTO) {

        Bid bid = bidMapper.toEntity(bidDTO);
//        TreeSet<Bid> bidList = bidDao.findAllByItemId(bid.getItemId());
//        if (bid.getBidPrice() <= bidList.last().getBidPrice()) {
//            //throw error
//        } else {
        bid = bidRepository.save(bid);
        bidDTO = bidMapper.toDTO(bid);
//        }
        return bidDTO;
    }

    @Override
    public List<Bid> getBidsListByUserId(int userId) {
        List<Bid> bidList = bidRepository.findAllByUserId(userId);
        return bidList;
    }

    @Override
    public ItemVm getWinningBid(int itemId) {
        ItemVm itemVm = new ItemVm();
        List<Bid> bidList = bidRepository.findAllByItemIdOrderByBidPriceDesc(itemId);
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
