package com.auctionbidtracker;

import com.auctionbidtracker.dto.ItemDTO;
import com.auctionbidtracker.service.ItemService;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

@SpringBootTest
@ActiveProfiles("test")
@RunWith(SpringJUnit4ClassRunner.class)
public class ItemControllerTestCases {
    Logger logger = LoggerFactory.getLogger(ItemControllerTestCases.class);

    @Autowired
    ItemService itemService;

    @Ignore
    @Test
    public void getItemsListForUser() {
        int userId = 2;
        List<ItemDTO> itemList = itemService.getItemsList(userId);
        for(ItemDTO item:itemList)
        {
            logger.info("id->"+item.getId());
            logger.info("itemName->"+item.getItemName());
            logger.info("basePrice->"+item.getBasePrice());
        }
    }

    @Ignore
    @Test
    public void saveItemDetails()
    {
        ItemDTO itemDTO=new ItemDTO();
        itemDTO.setItemName("NewItem");
        itemDTO.setBasePrice(4000);
        itemDTO = itemService.createItem(itemDTO);

        logger.info("id->"+itemDTO.getId());
        logger.info("itemName->"+itemDTO.getItemName());
        logger.info("basePrice->"+itemDTO.getBasePrice());
    }
}
