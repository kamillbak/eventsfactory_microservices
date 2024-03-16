package com.eventsfactory.locations.services;

import com.eventsfactory.locations.dto.LocationsDto;
import com.eventsfactory.locations.entity.Locations;
import com.eventsfactory.locations.exceptions.LocationAlreadyExistException;
import com.eventsfactory.locations.exceptions.ResourceNotFoundException;
import com.eventsfactory.locations.mapper.LocationsMapper;
import com.eventsfactory.locations.repository.LocationsRepository;
import com.eventsfactory.locations.services.api.LocationsService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
@AllArgsConstructor
public class LocationsServiceImpl implements LocationsService {

    LocationsRepository locationsRepository;

    @Override
    public void createLocation(LocationsDto locationDto) {
        List<Locations> sameLocations = locationsRepository.findByLocationNameAndAddress(locationDto.getLocationName(), locationDto.getAddress());
        if(!sameLocations.isEmpty()) {
            throw new LocationAlreadyExistException("Location with this name and address already exist");
        }
        Locations location = LocationsMapper.mapToLocation(locationDto, new Locations());
        location.setLocationId(Math.abs(new Random().nextLong()));
        locationsRepository.save(location);
    }

    @Override
    public LocationsDto getLocation(Long locationId) {
        Locations location = locationsRepository.findById(locationId).
                orElseThrow(() -> new ResourceNotFoundException("Location", "locationId", locationId.toString()));
        return LocationsMapper.mapToLocationDto(location, new LocationsDto());
    }

    @Override
    public boolean updateLocation(Long locationId, LocationsDto locationDto) {
        Locations location = locationsRepository.findById(locationId).
                orElseThrow(() -> new ResourceNotFoundException("Location", "locationId", locationId.toString()));
        LocationsMapper.mapToLocation(locationDto, location);
        locationsRepository.save(location);
        return true;
    }

    @Override
    public boolean deleteLocation(Long locationId) {
        Locations location = locationsRepository.findById(locationId).
                orElseThrow(() -> new ResourceNotFoundException("Location", "locationId", locationId.toString()));
        locationsRepository.deleteById(locationId);
        return true;
    }
}
