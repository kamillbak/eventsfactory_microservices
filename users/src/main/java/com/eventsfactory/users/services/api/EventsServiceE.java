package com.eventsfactory.users.services.api;

import com.eventsfactory.users.dto.EventsDto;

import java.util.List;

public interface EventsServiceE {
    /**
     *
     * @param userId - organizer Id
     * @return - events list
     */
    List<EventsDto> getEventsOrganizedByUser(Long userId);
}
