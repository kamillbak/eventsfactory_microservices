package com.eventsfactory.locations.dto;

import jakarta.validation.constraints.NotEmpty;
import lombok.Data;

@Data
public class LocationsDto {

    @NotEmpty(message = "Location name can not be a null or empty")
    private String locationName;

    @NotEmpty(message = "Location address can not be a null or empty")
    private String address;

    private String description;

    @NotEmpty(message = "Location capacity can not be a null or empty")
    private int capacity;

    @NotEmpty(message = "Rental pri Name can not be a null or empty")
    private int rentalPrice;
}


