package com.eventsfactory.events.repository;

import com.eventsfactory.events.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.time.LocalDateTime;
import java.util.List;

public interface EventsRepository extends JpaRepository<Events, Long> {

    @Query("SELECT e FROM Events e WHERE e.organizerId = :organizerId AND e.locationId = :locationId AND e.startDatetime = :startDatetime")
    List<Events> findEventsByOrganizerIdAndLocationIdAndStartDatetime(@Param("organizerId") Long organizerId,
                                                                      @Param("locationId") Long locationId,
                                                                      @Param("startDatetime") LocalDateTime startDatetime);
}
