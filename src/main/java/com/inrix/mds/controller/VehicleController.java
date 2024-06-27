package com.inrix.mds.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.exception.ParamErrors;
import com.inrix.mds.model.Vehicle;
import com.inrix.mds.model.response.ResponseWrapper;
import com.inrix.mds.repository.VehicleRepo;
import com.inrix.mds.service.VehicleService;
import io.swagger.v3.oas.annotations.Operation;
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
    @Operation
    public ResponseWrapper Vehicle (@PathVariable(required = false) UUID deviceId) {
        return vehicleService.getVehicle(deviceId);
    }

    @GetMapping(value = "/status")
    public ResponseWrapper vehicleStatus (@PathVariable(required = false) UUID deviceId){
        return vehicleStatus(deviceId);
    }

}
