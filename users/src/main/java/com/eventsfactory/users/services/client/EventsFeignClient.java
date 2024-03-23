package com.eventsfactory.users.services.client;

import com.eventsfactory.users.dto.EventsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient("events")
public interface EventsFeignClient {

    @GetMapping(value = "eventsfactory/api/events/get/organizedBy", consumes = "application/json")
    public ResponseEntity<List<EventsDto>> getEventsOrganizedByUser(@RequestParam Long userId);
}
