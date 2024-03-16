package com.eventsfactory.locations.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class LocationAlreadyExistException extends RuntimeException {

    public LocationAlreadyExistException(String message){
        super(message);
    }

}
