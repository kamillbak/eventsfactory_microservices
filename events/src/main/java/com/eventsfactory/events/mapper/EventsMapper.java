package com.eventsfactory.events.mapper;

import com.eventsfactory.events.dto.EventsDto;
import com.eventsfactory.events.entity.Events;

public class EventsMapper {
    public static EventsDto mapToEventsDto(Events events, EventsDto eventsDto) {
        eventsDto.setEventName(events.getEventName());
        eventsDto.setEventDescription(events.getEventDescription());
        eventsDto.setStartDatetime(events.getStartDatetime());
        eventsDto.setEndDatetime(events.getEndDatetime());
        eventsDto.setOrganizerId(events.getOrganizerId());
        eventsDto.setLocationId(events.getLocationId());
        return eventsDto;
    }

    public static Events mapToEvents(EventsDto eventsDto, Events events) {
        events.setEventName(eventsDto.getEventName());
        events.setEventDescription(eventsDto.getEventDescription());
        events.setStartDatetime(eventsDto.getStartDatetime());
        events.setEndDatetime(eventsDto.getEndDatetime());
        events.setOrganizerId(eventsDto.getOrganizerId());
        events.setLocationId(eventsDto.getLocationId());
        return events;
    }
}
