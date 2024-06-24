package com.inrix.mds.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.exception.ParamErrors;
import com.inrix.mds.model.Vehicle;
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
    public String Vehicle (@PathVariable(required = false) UUID deviceId) throws JsonProcessingException {
        if (deviceId == null){
            deviceId = UUID.fromString("00000000-0000-0000-0000-000000000000");
        }
        if (vehicleService.getVehicle(deviceId) == "Error"){
            throw new ParamErrors("Something went wrong....");
        }
        return vehicleService.getVehicle(deviceId);
    }

    @GetMapping(value = "/status")
    public void vehicleStatus (@PathVariable(required = false) UUID deviceId){


    }

}
