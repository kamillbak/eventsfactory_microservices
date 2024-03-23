package com.eventsfactory.users.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EventsDto {

    @NotEmpty(message = "Event Name can not be a null or empty")
    private String eventName;

    @NotEmpty(message = "Event Description can not be a null or empty")
    private String eventDescription;

    @NotEmpty(message = "Start date time can not be a null or empty")
    private LocalDateTime startDatetime;

    @NotEmpty(message = "End date time can not be a null or empty")
    private LocalDateTime endDatetime;

    @NotEmpty(message = "Organizer id can not be a null or empty")
    private Long organizerId;

    @NotEmpty(message = "Location Id can not be a null or empty")
    private Long locationId;
}