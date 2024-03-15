package com.eventsfactory.events.mapper;

import com.eventsfactory.events.dto.EventsDto;
import com.eventsfactory.events.entity.Events;

public class EventsMapper {
    public static EventsDto mapToEventDto(Events event, EventsDto eventDto) {
        eventDto.setEventName(event.getEventName());
        eventDto.setEventDescription(event.getEventDescription());
        eventDto.setStartDatetime(event.getStartDatetime());
        eventDto.setEndDatetime(event.getEndDatetime());
        eventDto.setOrganizerId(event.getOrganizerId());
        eventDto.setLocationId(event.getLocationId());
        return eventDto;
    }

    public static Events mapToEvent(EventsDto eventDto, Events event) {
        event.setEventName(eventDto.getEventName());
        event.setEventDescription(eventDto.getEventDescription());
        event.setStartDatetime(eventDto.getStartDatetime());
        event.setEndDatetime(eventDto.getEndDatetime());
        event.setOrganizerId(eventDto.getOrganizerId());
        event.setLocationId(eventDto.getLocationId());
        return event;
    }
}
