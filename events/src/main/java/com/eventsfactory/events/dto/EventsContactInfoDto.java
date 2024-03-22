package com.eventsfactory.events.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "events")
public record EventsContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
}
