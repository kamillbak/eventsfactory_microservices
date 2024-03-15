package com.eventsfactory.events.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST)
public class EventAlreadyExistException extends RuntimeException {

    public EventAlreadyExistException(String message){
        super(message);
    }

}
