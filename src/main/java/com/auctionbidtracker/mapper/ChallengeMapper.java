package com.auctionbidtracker.mapper;

import com.auctionbidtracker.dto.ChallengeDTO;
import com.auctionbidtracker.entities.Challenge;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {}, componentModel = "spring")
public interface ChallengeMapper {

    ChallengeMapper INSTANCE = Mappers.getMapper(ChallengeMapper.class);

    Challenge toEntity(ChallengeDTO challengeDTO);

    ChallengeDTO toDTO(Challenge challenge);
}
