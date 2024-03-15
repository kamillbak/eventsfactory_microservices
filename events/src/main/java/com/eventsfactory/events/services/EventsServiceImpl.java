package com.eventsfactory.events.services;

import com.eventsfactory.events.dto.EventsDto;
import com.eventsfactory.events.entity.Events;
import com.eventsfactory.events.mapper.EventsMapper;
import com.eventsfactory.events.repository.EventsRepository;
import com.eventsfactory.events.services.api.EventsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
@AllArgsConstructor
public class EventsServiceImpl implements EventsService {

    private EventsRepository eventsRepository;

    @Override
    public void createEvent(EventsDto eventsDto) {
        Events event = EventsMapper.mapToEvent(eventsDto, new Events());
        event.setEventId(new Random().nextLong());
        eventsRepository.save(event);
    }

    @Override
    public EventsDto getEvent(Long eventId) {
        Events event = eventsRepository.getReferenceById(eventId);
        return EventsMapper.mapToEventDto(event, new EventsDto());
    }

    @Override
    public boolean updateEvent(Long eventId, EventsDto eventsDto) {
        Events event = eventsRepository.getReferenceById(eventId);
        if (event == null) return false;
        EventsMapper.mapToEvent(eventsDto, event);
        eventsRepository.save(event);
        return true;
    }

    @Override
    public boolean deleteEvent(Long eventId) {
        Events event = eventsRepository.getReferenceById(eventId);
        if (event == null) return false;
        eventsRepository.deleteById(eventId);
        return true;
    }
}


