package com.auctionbidtracker.mapper;

import com.auctionbidtracker.dto.BidDTO;
import com.auctionbidtracker.entities.Bid;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-06T01:37:32+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_252 (Private Build)"
)
@Component
public class BidMapperImpl implements BidMapper {

    @Override
    public BidDTO toDTO(Bid bid) {
        if ( bid == null ) {
            return null;
        }

        BidDTO bidDTO = new BidDTO();

        bidDTO.setId( bid.getId() );
        bidDTO.setUserId( bid.getUserId() );
        bidDTO.setItemId( bid.getItemId() );
        bidDTO.setBidPrice( bid.getBidPrice() );

        return bidDTO;
    }

    @Override
    public Bid toEntity(BidDTO bidDTO) {
        if ( bidDTO == null ) {
            return null;
        }

        Bid bid = new Bid();

        bid.setId( bidDTO.getId() );
        bid.setUserId( bidDTO.getUserId() );
        bid.setItemId( bidDTO.getItemId() );
        bid.setBidPrice( bidDTO.getBidPrice() );

        return bid;
    }
}
