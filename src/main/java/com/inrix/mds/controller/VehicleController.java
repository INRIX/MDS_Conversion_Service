package com.inrix.mds.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.exception.ParamErrors;
import com.inrix.mds.model.Vehicle;
import com.inrix.mds.model.response.ResponseWrapper;
import com.inrix.mds.repository.VehicleRepo;
import com.inrix.mds.service.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping(value = MDSConstants.LIVE_API_VERSION + "/vehicles")
public class VehicleController {

    @Autowired
    VehicleService vehicleService;

    @GetMapping()
    public ResponseWrapper Vehicle (@PathVariable(required = false) UUID deviceId) {
        return vehicleService.getVehicle(deviceId);
    }

    // TODO: Implement Method
    @GetMapping(value = "/status")
    public void vehicleStatus (@PathVariable(required = false) UUID deviceId){


    }

}
