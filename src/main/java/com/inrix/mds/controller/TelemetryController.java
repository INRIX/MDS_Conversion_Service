package com.inrix.mds.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.constants.MDSType;
import com.inrix.mds.exception.ParamErrors;
import com.inrix.mds.model.Telemetry;
import com.inrix.mds.model.Trip;
import com.inrix.mds.model.response.ResponseWrapper;
import com.inrix.mds.repository.TelemetryRepo;
import com.inrix.mds.service.UniversalService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
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
@Tag(name = "Telemetry", description = "Retrieves telemetry data based on a certain data.")
public class TelemetryController {

    @Autowired
    UniversalService universalService;

    @GetMapping
    @Operation(description = "Feed of vehicle telemetry data within a hour.")
    public ResponseWrapper telemetry(@Parameter(description = "Format: yyyy-MM-dd'T'HH - e.g 2024-05-12T07:58:46.423", required = true) @RequestParam(value = "event_time", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH") LocalDateTime val) {
        return universalService.timeFilter(val, MDSType.TELEMETRY);
    }
}
