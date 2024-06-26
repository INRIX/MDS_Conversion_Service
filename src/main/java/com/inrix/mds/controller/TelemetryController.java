package com.inrix.mds.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.constants.MDSType;
import com.inrix.mds.exception.ParamErrors;
import com.inrix.mds.model.Telemetry;
import com.inrix.mds.model.Trip;
import com.inrix.mds.repository.TelemetryRepo;
import com.inrix.mds.service.UniversalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Service;
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

@RestController
@RequestMapping(value = MDSConstants.LIVE_API_VERSION + "/telemetry")
public class TelemetryController {

    @Autowired
    UniversalService universalService;

    @GetMapping
    public String telemetry(@RequestParam(value = "event_time", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH") LocalDateTime val) throws JsonProcessingException {
        if (val == null){
            throw new ParamErrors("event_time cannot be null.");
        }
        return universalService.timeFilter(val, MDSType.TELEMETRY);
    }
}
