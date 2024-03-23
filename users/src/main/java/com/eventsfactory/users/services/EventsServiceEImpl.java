package com.eventsfactory.users.services;

import com.eventsfactory.users.dto.EventsDto;
import com.eventsfactory.users.services.api.EventsServiceE;
import com.eventsfactory.users.services.client.EventsFeignClient;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@AllArgsConstructor
public class EventsServiceEImpl implements EventsServiceE {

    private EventsFeignClient eventsFeignClient;


    @Override
    public List<EventsDto> getEventsOrganizedByUser(Long userId) {
        ResponseEntity<List<EventsDto>> eventsDtoResponseEntity = eventsFeignClient.getEventsOrganizedByUser(userId);
        return eventsDtoResponseEntity.getBody();
    }
}
