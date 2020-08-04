package com.auctionbidtracker.mapper;

import com.auctionbidtracker.dto.BidDTO;
import com.auctionbidtracker.models.Bid;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;
import org.springframework.data.domain.Page;

import java.util.List;

@Mapper(uses = {}, componentModel = "spring")
public interface BidMapper {

    BidMapper INSTANCE = Mappers.getMapper(BidMapper.class);

    BidDTO toDTO(Bid bid);

    Bid toEntity(BidDTO bidDTO);

    List<BidDTO> toDTOList(Page<Bid> list);
}
