package com.inrix.mds.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.constants.MDSType;
import com.inrix.mds.exception.ParamErrors;
import com.inrix.mds.model.Event;
import com.inrix.mds.repository.EventRepo;
import com.inrix.mds.service.EventService;
import com.inrix.mds.service.UniversalService;
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
    UniversalService universalService;
    @Autowired
    EventService eventService;

    @GetMapping("/historical")
    public String eventHistory(@RequestParam(value = "event_time", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH") LocalDateTime val) throws JsonProcessingException {
        if (val == null){
            throw new ParamErrors("event_time cannot be null.");
        }
        return universalService.timeFilter(val, MDSType.EVENT);
    }

    @GetMapping("/recent")
    public String eventRecent(@RequestParam(value = "start_time", required = false) Long start, @RequestParam(value = "end_time", required = false) Long end) throws JsonProcessingException {
        return eventService.getRecent(start, end);
    }


}
