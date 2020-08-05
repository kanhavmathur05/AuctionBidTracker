package com.auctionbidtracker.mapper;

import com.auctionbidtracker.dto.UsersDTO;
import com.auctionbidtracker.entities.Users;
import javax.annotation.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2020-08-06T01:37:31+0530",
    comments = "version: 1.3.1.Final, compiler: javac, environment: Java 1.8.0_252 (Private Build)"
)
@Component
public class UsersMapperImpl implements UsersMapper {

    @Override
    public Users toEntity(UsersDTO usersDTO) {
        if ( usersDTO == null ) {
            return null;
        }

        Users users = new Users();

        users.setId( usersDTO.getId() );
        users.setUserName( usersDTO.getUserName() );
        users.setAccountBalance( usersDTO.getAccountBalance() );

        return users;
    }

    @Override
    public UsersDTO toDTO(Users users) {
        if ( users == null ) {
            return null;
        }

        UsersDTO usersDTO = new UsersDTO();

        usersDTO.setId( users.getId() );
        usersDTO.setUserName( users.getUserName() );
        usersDTO.setAccountBalance( users.getAccountBalance() );

        return usersDTO;
    }
}
