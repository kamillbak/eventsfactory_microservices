package com.eventsfactory.events.controller;

import com.eventsfactory.events.constants.EventsConstants;
import com.eventsfactory.events.dto.EventsDto;
import com.eventsfactory.events.dto.ResponseDto;
import com.eventsfactory.events.services.api.EventsService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "eventsfactory/api/events", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class EventsController {
    private EventsService eventsService;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createEvent(@RequestBody EventsDto eventsDto) {
        eventsService.createEvent(eventsDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(EventsConstants.STATUS_201,EventsConstants.MESSAGE_201));
    }

    @GetMapping("/get")
    public ResponseEntity<EventsDto> getEvent(@RequestParam Long eventId) {
       EventsDto eventsDto = eventsService.getEvent(eventId);
       return ResponseEntity.status(HttpStatus.OK).body(eventsDto);
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateEvent(@RequestParam Long eventId, @RequestBody EventsDto eventsDto) {
        boolean isUpdated = eventsService.updateEvent(eventId, eventsDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(EventsConstants.STATUS_200, EventsConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(EventsConstants.STATUS_417, EventsConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteEvent(@RequestParam Long eventId) {
        boolean isDeleted = eventsService.deleteEvent(eventId);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(EventsConstants.STATUS_200, EventsConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(EventsConstants.STATUS_417, EventsConstants.MESSAGE_417_DELETE));
        }
    }

}
