package com.auctionbidtracker.mapper;

import com.auctionbidtracker.dto.UsersDTO;
import com.auctionbidtracker.entities.Users;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(uses = {}, componentModel = "spring")
public interface UsersMapper {
    UsersMapper INSTANCE = Mappers.getMapper(UsersMapper.class);

    Users toEntity(UsersDTO usersDTO);

    UsersDTO toDTO(Users users);
}
