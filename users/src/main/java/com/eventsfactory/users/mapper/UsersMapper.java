package com.eventsfactory.users.mapper;

import com.eventsfactory.users.dto.UserDto;
import com.eventsfactory.users.entity.Users;

public class UsersMapper {

    public static UserDto mapToUserDto(Users users, UserDto userDto) {
        userDto.setFirstName(users.getFirstName());
        userDto.setLastName(users.getLastName());
        userDto.setEmail(users.getEmail());
        userDto.setMobileNumber(users.getMobileNumber());
        return userDto;
    }

    public static Users mapToUserEntity(UserDto userDto, Users users) {
        users.setFirstName(userDto.getFirstName());
        users.setLastName(userDto.getLastName());
        users.setEmail(userDto.getEmail());
        users.setMobileNumber(userDto.getMobileNumber());
        return users;
    }

}
