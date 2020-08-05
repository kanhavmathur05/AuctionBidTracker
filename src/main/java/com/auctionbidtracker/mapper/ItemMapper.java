package com.auctionbidtracker.mapper;

import com.auctionbidtracker.dto.ItemDTO;
import com.auctionbidtracker.entities.Item;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(uses = {}, componentModel = "spring")
public interface ItemMapper {

    ItemMapper INSTANCE = Mappers.getMapper(ItemMapper.class);

    Item toEntity(ItemDTO itemDTO);

    ItemDTO toDTO(Item item);

    List<ItemDTO> toDTOList(List<Item> itemList);
}
