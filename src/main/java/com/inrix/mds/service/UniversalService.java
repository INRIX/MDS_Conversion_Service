package com.inrix.mds.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.constants.MDSType;
import com.inrix.mds.exception.ParamErrors;
import com.inrix.mds.model.Event;
import com.inrix.mds.model.Telemetry;
import com.inrix.mds.model.Trip;
import com.inrix.mds.repository.EventRepo;
import com.inrix.mds.repository.TelemetryRepo;
import com.inrix.mds.repository.TripRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.*;

@Service
public class UniversalService {

    @Autowired
    TelemetryRepo telemetryRepo;

    @Autowired
    EventRepo eventRepo;

    @Autowired
    TripRepo tripRepo;

    @Autowired
    ObjectMapper getObjectMapper;


    public String timeFilter(LocalDateTime val, MDSType mdsType) throws JsonProcessingException {

        Instant current = val.toInstant(ZoneOffset.UTC);
        Instant Hour = current.plus(1, ChronoUnit.HOURS);

        if (Hour.isAfter(Instant.now())) {
            throw new ParamErrors("Time must be at least a hour before present.");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        LinkedHashMap<String, Object> json = new LinkedHashMap<>();
        json.put("version", MDSConstants.LIVE_API_VERSION);
        switch (mdsType){
            case EVENT: List<Event> events = new ArrayList<>();
            for (Event e : eventRepo.findAll()) {
                Instant eventTimestamp = Instant.ofEpochMilli(e.getTimestamp());
                if (eventTimestamp.equals(current) || eventTimestamp.isAfter(current)
                        && eventTimestamp.isBefore(Hour) || eventTimestamp.equals(Hour)) {
                    events.add(e);
                }
            }
            json.put("events", events);
            case TRIP: List<Trip> trips = new ArrayList<>();
                for (Trip t: tripRepo.findAll()){
                    Instant tripTimestamp = Instant.ofEpochMilli(t.getEndTime());
                    if (tripTimestamp.equals(current) || tripTimestamp.isAfter(current)
                            && tripTimestamp.isBefore(Hour) || tripTimestamp.equals(Hour)){
                        trips.add(t);
                    }
                }
                json.put("trips", trips);
            case TELEMETRY: List<Telemetry> telemetry = new ArrayList<>();
                for (Telemetry t: telemetryRepo.findAll()){
                    Instant telemetryTimestamp = Instant.ofEpochMilli(t.getTimestamp());
                    if (telemetryTimestamp.equals(current) || telemetryTimestamp.isAfter(current)
                            && telemetryTimestamp.isBefore(Hour) || telemetryTimestamp.equals(Hour)){
                        telemetry.add(t);
                    }
                }
                json.put("telemetry", telemetry);
        }

        return objectMapper.writeValueAsString(json);
    }


}
