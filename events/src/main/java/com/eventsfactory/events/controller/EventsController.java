package com.eventsfactory.events.controller;

import com.eventsfactory.events.dto.EventsDto;
import com.eventsfactory.events.services.api.EventsService;
import lombok.AllArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "eventsfactory/api/events", produces = {MediaType.APPLICATION_JSON_VALUE})
@AllArgsConstructor
@Validated
public class EventsController {
    private EventsService eventsService;

    @PostMapping("/create")
    public void createEvent(@RequestBody EventsDto eventsDto) {
        eventsService.createEvent(eventsDto);
    }

    @GetMapping("/get")
    public void getEvent(@RequestParam Long eventId) {
        eventsService.getEvent(eventId);
    }

    @PutMapping("/update")
    public void updateEvent(@RequestParam Long eventId, @RequestBody EventsDto eventsDto) {
        eventsService.updateEvent(eventId, eventsDto);
    }

    @DeleteMapping("/delete/")
    public void deleteEvent(@RequestParam Long eventId) {
        eventsService.deleteEvent(eventId);
    }

}
