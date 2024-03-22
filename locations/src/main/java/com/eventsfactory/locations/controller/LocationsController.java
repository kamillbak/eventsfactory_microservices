package com.eventsfactory.locations.controller;

import com.eventsfactory.locations.constants.LocationsConstants;
import com.eventsfactory.locations.dto.LocationsContactInfoDto;
import com.eventsfactory.locations.dto.LocationsDto;
import com.eventsfactory.locations.dto.ResponseDto;
import com.eventsfactory.locations.services.api.LocationsService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(path = "eventsfactory/api/locations", produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
public class LocationsController {

    private final LocationsService locationsService;

    private final Environment environment;

    private final LocationsContactInfoDto locationsContactInfoDto;

    public LocationsController(LocationsService locationsService, Environment environment, LocationsContactInfoDto locationsContactInfoDto) {
        this.locationsService = locationsService;
        this.environment = environment;
        this.locationsContactInfoDto = locationsContactInfoDto;
    }

    @Value("${build.version}")
    private String buildVersion;

    @PostMapping("/create")
    public ResponseEntity<ResponseDto> createLocation(@RequestBody LocationsDto locationDto) {
        locationsService.createLocation(locationDto);
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto(LocationsConstants.STATUS_201, LocationsConstants.MESSAGE_201));
    }

    @GetMapping("/get")
    public ResponseEntity<LocationsDto> getLocation(@RequestParam Long locationId) {
        LocationsDto locationDto = locationsService.getLocation(locationId);
        return ResponseEntity.status(HttpStatus.OK).body(locationDto);
    }


    @PutMapping("/update")
    public ResponseEntity<ResponseDto> updateLocation(@RequestParam Long locationId, @RequestBody LocationsDto locationDto) {
        boolean isUpdated = locationsService.updateLocation(locationId, locationDto);
        if(isUpdated) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LocationsConstants.STATUS_200, LocationsConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LocationsConstants.STATUS_417, LocationsConstants.MESSAGE_417_UPDATE));
        }
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDto> deleteLocation(@RequestParam Long locationId) {
        boolean isDeleted = locationsService.deleteLocation(locationId);
        if(isDeleted) {
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new ResponseDto(LocationsConstants.STATUS_200, LocationsConstants.MESSAGE_200));
        }
        else {
            return ResponseEntity
                    .status(HttpStatus.EXPECTATION_FAILED)
                    .body(new ResponseDto(LocationsConstants.STATUS_417, LocationsConstants.MESSAGE_417_DELETE));
        }
    }

    @GetMapping("/build-info")
    public ResponseEntity<String> getBuildInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(buildVersion);
    }

    @GetMapping("/java-version")
    public ResponseEntity<String> getJavaVersion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }

    @GetMapping("/contact-info")
    public ResponseEntity<LocationsContactInfoDto> getContactInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(locationsContactInfoDto);
    }

}