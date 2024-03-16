package com.eventsfactory.users.controller;

import com.eventsfactory.users.constants.UsersConstants;
import com.eventsfactory.users.dto.ResponseDto;
import com.eventsfactory.users.dto.UserDto;
import com.eventsfactory.users.services.api.UsersService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "eventsfactory/api/users", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class UsersController {
    private UsersService usersService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createUser(@RequestBody UserDto userDto) {
        usersService.createUser(userDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(UsersConstants.STATUS_201, UsersConstants.MESSAGE_201));
    }

    @GetMapping("/get")
    public ResponseEntity<UserDto> getUser(@RequestParam Long userId) {
        UserDto userDto = usersService.getUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(userDto);
    }


    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateUser(@RequestParam Long userId, @RequestBody UserDto userDto) {
        boolean isUpdated = usersService.updateUser(userId, userDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(UsersConstants.STATUS_200, UsersConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(UsersConstants.STATUS_417, UsersConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteUser(@RequestParam Long userId) {
        boolean isDeleted = usersService.deleteUser(userId);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(UsersConstants.STATUS_200, UsersConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(UsersConstants.STATUS_417, UsersConstants.MESSAGE_417_DELETE));
        }
    }

}
