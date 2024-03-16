package com.eventsfactory.users.services;

import com.eventsfactory.users.dto.UserDto;
import com.eventsfactory.users.entity.Users;
import com.eventsfactory.users.exceptions.ResourceNotFoundException;
import com.eventsfactory.users.exceptions.UserAlreadyExistException;
import com.eventsfactory.users.mapper.UsersMapper;
import com.eventsfactory.users.repository.UsersRepository;
import com.eventsfactory.users.services.api.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;


@Service
@AllArgsConstructor
public class UsersServiceImpl implements UsersService {

    UsersRepository usersRepository;

    @Override
    public void createUser(UserDto userDto) {
        List<Users> sameEmailUsers = usersRepository.findByEmail(userDto.getEmail());
        if(!sameEmailUsers.isEmpty()) {
            throw new UserAlreadyExistException("User with this email already exist");
        }
        Users users = UsersMapper.mapToUserEntity(userDto, new Users());
        users.setUserId(Math.abs(new Random().nextLong()));
        usersRepository.save(users);
    }

    @Override
    public UserDto getUser(Long userId) {
        Users users = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User","userId",userId.toString()));
        return UsersMapper.mapToUserDto(users, new UserDto());
    }

    @Override
    public boolean updateUser(Long userId, UserDto userDto) {
        Users users = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User","userId",userId.toString()));
        UsersMapper.mapToUserEntity(userDto, users);
        usersRepository.save(users);
        return true;
    }

    @Override
    public boolean deleteUser(Long userId) {
        Users users = usersRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User","userId",userId.toString()));
        usersRepository.deleteById(userId);
        return true;
    }
}
