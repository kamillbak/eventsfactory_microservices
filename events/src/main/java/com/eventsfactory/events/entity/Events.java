package com.eventsfactory.events.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.*;

import java.time.LocalDateTime;


@Entity
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class Events extends BaseEntity {
    @Id
    private Long eventId;

    private String eventName;

    private String eventDescription;

    private LocalDateTime startDatetime;

    private LocalDateTime endDatetime;

    private Long organizerId;

    private Long locationId;
}
