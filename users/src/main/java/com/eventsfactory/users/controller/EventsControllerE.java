package com.eventsfactory.users.controller;

import com.eventsfactory.users.dto.EventsDto;
import com.eventsfactory.users.services.api.EventsServiceE;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(path = "eventsfactory/api/users", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class EventsControllerE {

    private EventsServiceE eventsServiceE;

    public EventsControllerE(EventsServiceE eventsServiceE) {
        this.eventsServiceE = eventsServiceE;
    }


    @GetMapping("/get/events/organizedBy")
    public ResponseEntity<List<EventsDto>> getEventsOrganizedByUser(@RequestParam Long userId) {
        List<EventsDto> eventsDtoList= eventsServiceE.getEventsOrganizedByUser(userId);
        return ResponseEntity.status(HttpStatus.OK).body(eventsDtoList);
    }
}
