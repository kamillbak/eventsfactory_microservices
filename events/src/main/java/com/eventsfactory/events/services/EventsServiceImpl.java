package com.eventsfactory.events.services;

import com.eventsfactory.events.dto.EventsDto;
import com.eventsfactory.events.entity.Events;
import com.eventsfactory.events.exceptions.EventAlreadyExistException;
import com.eventsfactory.events.exceptions.ResourceNotFoundException;
import com.eventsfactory.events.mapper.EventsMapper;
import com.eventsfactory.events.repository.EventsRepository;
import com.eventsfactory.events.services.api.EventsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class EventsServiceImpl implements EventsService {

    private EventsRepository eventsRepository;

    @Override
    public void createEvent(EventsDto eventsDto) {
        List<Events> sameEvents = eventsRepository.findEventsByOrganizerIdAndLocationIdAndStartDatetime(eventsDto.getOrganizerId(), eventsDto.getLocationId(), eventsDto.getStartDatetime());
        if (!sameEvents.isEmpty()) {
            throw new EventAlreadyExistException("Event with this date, organizer and location already exist.");
        }
        Events event = EventsMapper.mapToEvent(eventsDto, new Events());
        event.setEventId(Math.abs(new Random().nextLong()));
        eventsRepository.save(event);
    }


    @Override
    public EventsDto getEvent(Long eventId) {
        Events event = eventsRepository.findById(eventId).
                orElseThrow(() -> new ResourceNotFoundException("Event", "eventId", eventId.toString()));
        return EventsMapper.mapToEventDto(event, new EventsDto());
    }

    @Override
    public List<EventsDto> getEventsOrganizedByUser(Long userId) {
        List<Events> eventsList = eventsRepository.findEventsByOrganizerId(userId);
        if(eventsList.isEmpty()) {
            throw new ResourceNotFoundException("Events", "organizerId", userId.toString());
        }
        return eventsList.stream()
                .map(e -> EventsMapper.mapToEventDto(e, new EventsDto()))
                .collect(Collectors.toList());
    }

    @Override
    public boolean updateEvent(Long eventId, EventsDto eventsDto) {
        Events event = eventsRepository.findById(eventId).
                orElseThrow(() -> new ResourceNotFoundException("Event", "eventId", eventId.toString()));
        EventsMapper.mapToEvent(eventsDto, event);
        eventsRepository.save(event);
        return true;
    }

    @Override
    public boolean deleteEvent(Long eventId) {
        Events event = eventsRepository.findById(eventId).
                orElseThrow(() -> new ResourceNotFoundException("Event", "eventId", eventId.toString()));
        eventsRepository.deleteById(eventId);
        return true;
    }
}


