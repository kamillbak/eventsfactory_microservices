package com.eventsfactory.events.controller;

import com.eventsfactory.events.constants.EventsConstants;
import com.eventsfactory.events.dto.EventsContactInfoDto;
import com.eventsfactory.events.dto.EventsDto;
import com.eventsfactory.events.dto.ResponseDto;
import com.eventsfactory.events.services.api.EventsService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "eventsfactory/api/events", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class EventsController {

    private final EventsService eventsService;

    private final Environment environment;

    private final EventsContactInfoDto eventsContactInfoDto;

    public EventsController(EventsService eventsService, Environment environment, EventsContactInfoDto eventsContactInfoDto) {
        this.eventsService = eventsService;
        this.environment = environment;
        this.eventsContactInfoDto = eventsContactInfoDto;
    }

    @Value("${build.version}")
    private String buildVersion;

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
    public ResponseEntity<EventsContactInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(eventsContactInfoDto);
    }

}
