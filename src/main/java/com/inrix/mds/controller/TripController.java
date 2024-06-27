package com.inrix.mds.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.constants.MDSType;
import com.inrix.mds.exception.ParamErrors;
import com.inrix.mds.model.Event;
import com.inrix.mds.model.Trip;
import com.inrix.mds.model.response.ResponseWrapper;
import com.inrix.mds.repository.TripRepo;
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

@RestController
@RequestMapping(value = MDSConstants.LIVE_API_VERSION + "/trips")
@Tag(name = "Trip", description = "Retrieves trip data based on a certain date.")
public class TripController {

    @Autowired
    UniversalService universalService;
    @GetMapping
    @Operation(description = "Query historical trip data.")
    public ResponseWrapper trips(@Parameter(description = "Format: yyyy-MM-dd'T'HH - e.g 2024-05-12T07:58:46.423", required = true) @RequestParam(value = "end_time", required = false) @DateTimeFormat(pattern = "yyyy-MM-dd'T'HH") LocalDateTime val) {
        return universalService.timeFilter(val, MDSType.TRIP);
    }
}
