package com.eventsfactory.locations.repository;

import com.eventsfactory.locations.entity.Locations;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface LocationsRepository extends JpaRepository<Locations, Long> {

    List<Locations> findByLocationNameAndAddress(String locationName, String address);

}
