package com.eventsfactory.users.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class UserDto {

    @NotEmpty(message = "First name name can not be a null or empty")
    private String firstName;

    @NotEmpty(message = "Last name name can not be a null or empty")
    private String lastName;

    @NotEmpty(message = "Email can not be a null or empty")
    private String email;

    @NotEmpty(message = "Mobile number can not be a null or empty")
    private String mobileNumber;
}