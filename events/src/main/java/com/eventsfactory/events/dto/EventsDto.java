package com.eventsfactory.events.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventsDto {

    @NotEmpty(message = "Event Name can not be a null or empty")
    private String eventName;

    @NotEmpty(message = "Event Name can not be a null or empty")
    private String eventDescription;

    @NotEmpty(message = "Event Name can not be a null or empty")
    private LocalDateTime startDatetime;

    @NotEmpty(message = "Event Name can not be a null or empty")
    private LocalDateTime endDatetime;

    @NotEmpty(message = "Event Name can not be a null or empty")
    private Long organizerId;

    @NotEmpty(message = "Event Name can not be a null or empty")
    private Long locationId;
}