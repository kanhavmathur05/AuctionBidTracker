package com.auctionbidtracker.mapper;

import com.auctionbidtracker.dto.ItemDTO;
import com.auctionbidtracker.models.Item;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-04T16:50:52+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_252 (Private Build)"
)
@Component
public class ItemMapperImpl implements ItemMapper {

    @Override
    public Item toEntity(ItemDTO itemDTO) {
        if ( itemDTO == null ) {
            return null;
        }

        Item item = new Item();

        item.setId( itemDTO.getId() );
        item.setItemName( itemDTO.getItemName() );
        item.setBasePrice( itemDTO.getBasePrice() );

        return item;
    }

    @Override
    public ItemDTO toDTO(Item item) {
        if ( item == null ) {
            return null;
        }

        ItemDTO itemDTO = new ItemDTO();

        itemDTO.setId( item.getId() );
        itemDTO.setItemName( item.getItemName() );
        itemDTO.setBasePrice( item.getBasePrice() );

        return itemDTO;
    }

    @Override
    public List<ItemDTO> toDTOList(List<Item> itemList) {
        if ( itemList == null ) {
            return null;
        }

        List<ItemDTO> list = new ArrayList<ItemDTO>( itemList.size() );
        for ( Item item : itemList ) {
            list.add( toDTO( item ) );
        }

        return list;
    }
}
