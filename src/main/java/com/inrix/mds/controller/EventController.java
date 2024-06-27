package com.inrix.mds.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.constants.MDSType;
import com.inrix.mds.exception.ParamErrors;
import com.inrix.mds.model.Event;
import com.inrix.mds.model.response.ResponseWrapper;
import com.inrix.mds.repository.EventRepo;
import com.inrix.mds.service.EventService;
import com.inrix.mds.service.UniversalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Event", description = "Retrieves event data based on certain times.")
public class EventController {
    @Autowired
    UniversalService universalService;
    @Autowired
    EventService eventService;

    @GetMapping("/historical")
    @Operation(description = "Returns a list of Event objects, describing the activity of the Provider's vehicles")
    public ResponseWrapper eventHistory(@Parameter(description = "Format: yyyy-MM-dd'T'HH - e.g 2024-05-12T07:58:46.423", required = true) @RequestParam(value = "event_time", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH") LocalDateTime val) {
        return universalService.timeFilter(val, MDSType.EVENT);
    }

    @GetMapping("/recent")
    @Operation(description = "Returns a list of Event objects, describing the activity of the Provider's vehicles. Recent events are at most two weeks old and can be queried with start/stop time.")
    public ResponseWrapper eventRecent(@Parameter(description = "Format: EpochMilli - e.g 1719490684147", required = true) @RequestParam(value = "start_time", required = false) Long start, @Parameter(description = "Format: EpochMilli - e.g 1719490684147", required = true)  @RequestParam(value = "end_time", required = false) Long end) {
        return eventService.getRecent(start, end);
    }


}
