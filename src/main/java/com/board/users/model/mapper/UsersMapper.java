package com.board.users.model.mapper;

import com.board.users.model.dto.UsersRequestDto;
import com.board.users.model.dto.UsersResponseDto;
import com.board.users.model.entity.Users;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsersMapper {

    @Mapping(target = "id", source = "userId")
    @Mapping(target = "name", source = "userName")
    Users dtoToEntity(UsersRequestDto usersRequestDto);

    UsersResponseDto entityToDto(Users users);

}
