package com.auctionbidtracker.mapper;

import com.auctionbidtracker.dto.ChallengeDTO;
import com.auctionbidtracker.entities.Challenge;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-05T11:56:47+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_252 (Private Build)"
)
@Component
public class ChallengeMapperImpl implements ChallengeMapper {

    @Override
    public Challenge toEntity(ChallengeDTO challengeDTO) {
        if ( challengeDTO == null ) {
            return null;
        }

        Challenge challenge = new Challenge();

        return challenge;
    }

    @Override
    public ChallengeDTO toDTO(Challenge challenge) {
        if ( challenge == null ) {
            return null;
        }

        ChallengeDTO challengeDTO = new ChallengeDTO();

        return challengeDTO;
    }
}
