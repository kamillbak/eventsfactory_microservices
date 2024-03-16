package com.eventsfactory.locations.mapper;

import com.eventsfactory.locations.dto.LocationsDto;
import com.eventsfactory.locations.entity.Locations;

public class LocationsMapper {

    public static LocationsDto mapToLocationDto(Locations location, LocationsDto locationDto) {
        locationDto.setLocationName(location.getLocationName());
        locationDto.setAddress(location.getAddress());
        locationDto.setDescription(location.getDescription());
        locationDto.setCapacity(location.getCapacity());
        locationDto.setRentalPrice(location.getRentalPrice());
        return locationDto;
    }

    public static Locations mapToLocation(LocationsDto locationDto, Locations location) {
        location.setLocationName(locationDto.getLocationName());
        location.setAddress(locationDto.getAddress());
        location.setDescription(locationDto.getDescription());
        location.setCapacity(locationDto.getCapacity());
        location.setRentalPrice(locationDto.getRentalPrice());
        return location;
    }
}