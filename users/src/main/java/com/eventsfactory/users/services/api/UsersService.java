package com.eventsfactory.users.services.api;

import com.eventsfactory.users.dto.UserDto;

public interface UsersService {

    void createUser(UserDto userDto);

    UserDto getUser(Long userId);

    boolean updateUser(Long userId, UserDto userDto);

    boolean deleteUser(Long userId);
}
