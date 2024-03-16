package com.eventsfactory.locations.services.api;

import com.eventsfactory.locations.dto.LocationsDto;

public interface LocationsService {

    void createLocation(LocationsDto locationDto);

    LocationsDto getLocation(Long locationId);

    boolean updateLocation(Long locationId, LocationsDto locationDto);

    boolean deleteLocation(Long locationId);

}
