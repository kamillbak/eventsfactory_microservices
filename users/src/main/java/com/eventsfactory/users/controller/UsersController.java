package com.eventsfactory.users.controller;

import com.eventsfactory.users.constants.UsersConstants;
import com.eventsfactory.users.dto.ResponseDto;
import com.eventsfactory.users.dto.UserDto;
import com.eventsfactory.users.dto.UsersContactInfoDto;
import com.eventsfactory.users.services.api.UsersService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "eventsfactory/api/users", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class UsersController {

    private UsersService usersService;

    private final Environment environment;

    private final UsersContactInfoDto usersContactInfoDto;

    public UsersController(UsersService usersService, Environment environment, UsersContactInfoDto usersContactInfoDto) {
        this.usersService = usersService;
        this.environment = environment;
        this.usersContactInfoDto = usersContactInfoDto;
    }

    @Value("${build.version}")
    private String buildVersion;

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

    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
    }

    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }

    @GetMapping("/contact-info")
    public ResponseEntity<UsersContactInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(usersContactInfoDto);
    }

}
