package com.eventsfactory.events.services.api;

import com.eventsfactory.events.dto.EventsDto;

public interface EventsService {
    /**
     * @param organizerId - id of organizer
     * @param LocationId - id of location
     * other data are mocked for now
     */
    void createEvent(String name, Long organizerId, Long LocationId);

    /**
     *
     * @param eventId - id of the event
     * @return event dto
     */
    EventsDto getEvent(Long eventId);

    /**
     *
     * @param eventsDto event dto
     * @return if succeeded
     */
    boolean updateEvent(Long eventId, EventsDto eventsDto);

    /**
     *
     * @param eventId ecent id
     * @return if succeeded
     */
    boolean deleteEvent(Long eventId);

}
