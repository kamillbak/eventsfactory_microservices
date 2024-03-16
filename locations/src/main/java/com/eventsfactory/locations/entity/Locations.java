package com.eventsfactory.locations.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Locations extends BaseEntity {
    @Id
    private Long locationId;

    private String locationName;

    private String address;

    private String description;

    private int capacity;

    private int rentalPrice;
}



