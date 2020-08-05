package com.auctionbidtracker;

import com.auctionbidtracker.dto.BidDTO;
import com.auctionbidtracker.entities.Bid;
import com.auctionbidtracker.service.BidService;
import com.auctionbidtracker.vm.ItemVm;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Profile;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;


@SpringBootTest
@Profile("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class BidControllerTestCases {

    @Autowired
    BidService bidService;

    Logger logger = LoggerFactory.getLogger(BidControllerTestCases.class);

    @Ignore
    @Test
    public void saveBidForItem() {
        BidDTO bidDTO = new BidDTO();
        bidDTO.setBidPrice(23200);
        bidDTO.setItemId(1);
        bidDTO.setUserId(3);
        BidDTO result = bidService.saveBidForItem(bidDTO);

        logger.info("bidId->", result.getId());
        logger.info("bidPrice->", result.getBidPrice());
        logger.info("itemId->", result.getItemId());
        logger.info("userId->", result.getUserId());
    }

    @Ignore
    @Test
    public void getWinningBid() {
        int itemId = 2;
        ItemVm itemVm = bidService.getWinningBid(itemId);
        logger.info("BidId->" + itemVm.getBidId());
        logger.info("BidPrice->" + itemVm.getBidPrice());
        logger.info("ItemId->" + itemVm.getItemId());
        logger.info("Id->" + itemVm.getUsers().getId());
        logger.info("UserName->" + itemVm.getUsers().getUserName());
        logger.info("AccountBalance->" + itemVm.getUsers().getAccountBalance());
    }

    @Ignore
    @Test
    public void geAllBidsForItem() {
        int itemId = 1;
        Pageable pageable = PageRequest.of(0, 10);
        Page<Bid> resultList = bidService.getAllBidsForItem(itemId, pageable);
        for (Bid bid : resultList) {
            logger.info("id->" + bid.getId());
            logger.info("itemPrice->" + bid.getItemId());
            logger.info("bidPrice->" + bid.getBidPrice());
            logger.info("userId->" + bid.getUserId());
        }
    }

    @Test
    public void getBidsListByUserId() {
        int userId = 2;
        List<Bid> resultList = bidService.getBidsListByUserId(userId);
        for (Bid bid : resultList) {
            logger.info("id->" + bid.getId());
            logger.info("itemId->" + bid.getItemId());
            logger.info("bidPrice->" + bid.getBidPrice());
            logger.info("userId->" + bid.getUserId());
        }
    }
}
