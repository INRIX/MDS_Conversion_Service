package com.inrix.mds.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.exception.ParamErrors;
import com.inrix.mds.model.Event;
import com.inrix.mds.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneOffset;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.fasterxml.jackson.databind.ObjectMapper;


@RestController
@RequestMapping(value =  MDSConstants.LIVE_API_VERSION + "/events")
public class EventController {
    @Autowired
    private EventRepo eventRepo;

    @GetMapping("/historical")
    public String eventHistory(@RequestParam("event_time") @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH") LocalDateTime dateTime) throws JsonProcessingException {
        if (dateTime == null){
            throw new ParamErrors("event_time cannot be null.");
        }

        List<Event> events = new ArrayList<>();
        ObjectMapper objectMapper = new ObjectMapper();
        Instant utcConversion = dateTime.toInstant(ZoneOffset.UTC);
        Instant Hour = utcConversion.plus(1, ChronoUnit.HOURS);

        if (Hour.isAfter(Instant.now())) {
            throw new ParamErrors("Time must be at least a hour before present.");
        }


        for (Event e: eventRepo.findAll()){
            Instant eventTimestamp = Instant.ofEpochMilli(e.getTimestamp());
            if (eventTimestamp.equals(utcConversion) || eventTimestamp.isAfter(utcConversion)
                    && eventTimestamp.isBefore(Hour) || eventTimestamp.equals(Hour)){
                events.add(e);
            }
        }
        Map<String, Object> json = new HashMap<>();
        json.put("version", MDSConstants.LIVE_API_VERSION);
        json.put("events", events);
        String jsonConversion = objectMapper.writeValueAsString(json);

        return jsonConversion;
    }



}
