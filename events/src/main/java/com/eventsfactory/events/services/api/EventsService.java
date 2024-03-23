package com.eventsfactory.events.services.api;

import com.eventsfactory.events.dto.EventsDto;

import java.util.List;

public interface EventsService {
    /**
     *
     * @param eventsDto - events data
     */
    void createEvent(EventsDto eventsDto);

    /**
     *
     * @param eventId - id of the event
     * @return event dto
     */
    EventsDto getEvent(Long eventId);

    /**
     *
     * @param userId - organizer id
     * @return List of event
     */
    List<EventsDto> getEventsOrganizedByUser(Long userId);

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
