package com.inrix.mds.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.exception.ParamErrors;
import com.inrix.mds.model.Vehicle;
import com.inrix.mds.model.response.ResponseWrapper;
import com.inrix.mds.repository.VehicleRepo;
import com.inrix.mds.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = MDSConstants.LIVE_API_VERSION + "/vehicles")
@Tag(name = "Vehicle", description = "Retrieves vehicle data.")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping()
    @Operation(description = "Returns the specified vehicle (if a device_id is provided) or a list of vehicles. It contains vehicle properties that do not change often. When /vehicles is called without specifying a device ID it should return every vehicle on service in the last 30 days.")
    public ResponseWrapper Vehicle (@Parameter(description = "Format: UUID - e.g 550e8400-e29b-41d4-a716-446655440000", required = false) @PathVariable(required = false) UUID deviceId) {
        return vehicleService.getVehicle(deviceId);
    }

    @GetMapping(value = "/status")
    @Operation(description = " Return the current status of all vehicles on the system, however vehicles not in a PROW state (removed, missing, elsewhere) will only persist in the feed for 90 minutes before being removed. If a device Id is specified, the vehicle is returned along with its vehicle state.")
    public ResponseWrapper vehicleStatus (@PathVariable(required = false) UUID deviceId){
        return vehicleService.getVehicleStatus(deviceId);
    }

}
