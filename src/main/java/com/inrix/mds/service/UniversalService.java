package com.inrix.mds.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.constants.MDSType;
import com.inrix.mds.exception.ParamErrors;
import com.inrix.mds.model.Event;
import com.inrix.mds.model.Telemetry;
import com.inrix.mds.model.Trip;
import com.inrix.mds.model.response.ResponseWrapper;
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


    public String timeFilter(MDSType mdsType) {
        throw new ParamErrors("time cannot be null.");
    }


    public ResponseWrapper timeFilter(LocalDateTime val, MDSType mdsType) {

        long current = val.toInstant(ZoneOffset.UTC).toEpochMilli();
        Instant currentInstant = Instant.ofEpochMilli(current);

        Instant hourLaterInstant = currentInstant.plus(1, ChronoUnit.HOURS);
        long Hour = hourLaterInstant.toEpochMilli();


        if (hourLaterInstant.isAfter(Instant.now())) {
            throw new ParamErrors("Time must be at least a hour before present.");
        }
        ResponseWrapper responseWrapper = new ResponseWrapper();
        switch (mdsType) {
            case EVENT:
//                List<Event> events = new ArrayList<>();
//                for (Event e : eventRepo.findAll()) {
//                    Instant eventTimestamp = Instant.ofEpochMilli(e.getTimestamp());
//                    if (eventTimestamp.equals(current) || eventTimestamp.isAfter(current)
//                            && eventTimestamp.isBefore(Hour) || eventTimestamp.equals(Hour)) {
//                        events.add(e);
//                    }
//                }
                responseWrapper.setData(eventRepo.findByTimestampGreaterThanEqualAndTimestampLessThanEqual(current,Hour));
                break;
            case TRIP:
//                List<Trip> trips = new ArrayList<>();
//                for (Trip t : tripRepo.findAll()) {
//                    Instant tripTimestamp = Instant.ofEpochMilli(t.getEndTime());
//                    if (tripTimestamp.equals(current) || tripTimestamp.isAfter(current)
//                            && tripTimestamp.isBefore(Hour) || tripTimestamp.equals(Hour)) {
//                        trips.add(t);
//                    }
//                }
                responseWrapper.setData(tripRepo.findByStartTimeGreaterThanEqualAndEndTimeLessThanEqual(current,Hour));
                break;
            case TELEMETRY:
//                List<Telemetry> telemetry = new ArrayList<>();
//                for (Telemetry t : telemetryRepo.findAll()) {
//                    Instant telemetryTimestamp = Instant.ofEpochMilli(t.getTimestamp());
//                    if (telemetryTimestamp.equals(current) || telemetryTimestamp.isAfter(current)
//                            && telemetryTimestamp.isBefore(Hour) || telemetryTimestamp.equals(Hour)) {
//                        telemetry.add(t);
//                    }
//                }
                responseWrapper.setData(telemetryRepo.findByTimestampGreaterThanEqualAndTimestampLessThanEqual(current,Hour));
                break;
        }

        return responseWrapper;
    }


}
