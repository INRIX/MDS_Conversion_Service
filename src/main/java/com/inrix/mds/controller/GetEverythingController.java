package com.inrix.mds.controller;

import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.model.Event;
import com.inrix.mds.model.Telemetry;
import com.inrix.mds.model.Trip;
import com.inrix.mds.repository.EventRepo;
import com.inrix.mds.repository.TelemetryRepo;
import com.inrix.mds.repository.TripRepo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value =  MDSConstants.LIVE_API_VERSION + "/everything")
@Tag(name = "All Data", description = "Retrieves All Data for each table. DO NO USE IN PRODUCTION.")
public class GetEverythingController {
    @Autowired
    TelemetryRepo telemetryRepo;

    @Autowired
    EventRepo eventRepo;

    @Autowired
    TripRepo tripRepo;

    @GetMapping(value="/allTelemetry")
    @Operation(description = "Returns a list of All Telemetry data in the database. This is not recommended for production use.")
    public List<Telemetry> getAllTelemetry() {
      return telemetryRepo.findAll();
    }
    @GetMapping(value="/allEvents")
    @Operation(description = "Returns a list of All Events data in the database. This is not recommended for production use.")
    public List<Event> getAllEvents() {
        return eventRepo.findAll();
    }
    @GetMapping(value="/allTrips")
    @Operation(description = "Returns a list of All Trips data in the database. This is not recommended for production use.")
    public List<Trip> getAllTrips() {
        return tripRepo.findAll();
    }

}
