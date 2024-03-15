package com.eventsfactory.events.repository;

import com.eventsfactory.events.entity.Events;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventsRepository extends JpaRepository<Events, Long> {
}
