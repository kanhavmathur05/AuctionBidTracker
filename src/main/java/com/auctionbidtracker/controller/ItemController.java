package com.auctionbidtracker.controller;

import com.auctionbidtracker.dto.ItemDTO;
import com.auctionbidtracker.service.ItemService;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class ItemController {

    @Autowired
    ItemService itemService;

    Logger logger = LoggerFactory.getLogger(ItemController.class);

    @ApiOperation("This API is used to get the list of Items on which a user has bid.")
    @GetMapping("/get-items-for-user/{userId}")
    public ResponseEntity<List<ItemDTO>> getItemsList(@PathVariable int userId) {
        List<ItemDTO> resultBody = itemService.getItemsList(userId);
        return ResponseEntity.status(HttpStatus.OK).body(resultBody);
    }

    @ApiOperation("This API is used to get create items for auctions.")
    @PostMapping("/create-item")
    public ResponseEntity<ItemDTO> saveItemDetails(@RequestBody ItemDTO itemDTO) {
        ItemDTO resultBody = itemService.createItem(itemDTO);
        return ResponseEntity.status(HttpStatus.OK).body(resultBody);
    }
}
