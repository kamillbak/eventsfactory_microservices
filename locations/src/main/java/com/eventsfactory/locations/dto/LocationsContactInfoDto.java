package com.eventsfactory.locations.dto;

import org.springframework.boot.context.properties.ConfigurationProperties;

import java.util.List;
import java.util.Map;

@ConfigurationProperties(prefix = "locations")
public record LocationsContactInfoDto(String message, Map<String, String> contactDetails, List<String> onCallSupport) {
}
