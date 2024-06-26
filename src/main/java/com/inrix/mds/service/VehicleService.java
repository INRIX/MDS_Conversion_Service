package com.inrix.mds.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.model.Event;
import com.inrix.mds.model.Vehicle;
import com.inrix.mds.model.enums.VehicleState;
import com.inrix.mds.model.response.ResponseWrapper;
import com.inrix.mds.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.Duration;
import java.time.Instant;
import java.util.*;

@Service
public class VehicleService {

    @Autowired
    VehicleRepo vehicleRepo;

    public ResponseWrapper getVehicle(){
        List<Vehicle> vehicle = new ArrayList<>();
        ResponseWrapper responseWrapper = new ResponseWrapper();
        for (Vehicle v: vehicleRepo.findAll()){
            if (v.getEvents().getLast().getTimestamp() >= (Instant.now().minus(Duration.ofDays(30)).toEpochMilli())){
                vehicle.add(v);
            }
        }
            responseWrapper.setData("vehicle: " + vehicle);
            return responseWrapper;
    }

    public ResponseWrapper getVehicle(UUID val){
        List<Vehicle> vehicle = new ArrayList<>();
        ResponseWrapper responseWrapper = new ResponseWrapper();

        for (Vehicle v: vehicleRepo.findAll()){
            if (val == v.getDeviceId()){
                vehicle.add(v);
            }
        }
        responseWrapper.setData(vehicle);
        return responseWrapper;
    }

//    public String getVehicleStatus(UUID val) throws JsonProcessingException {
//        Map<String, Object> json = new HashMap<>();
//        json.put("version", MDSConstants.LIVE_API_VERSION);
//        List<VehicleState> states = new ArrayList<>();
//
//        for (Vehicle v: vehicleRepo.findAll()){
//            for (Event e: v.getEvents()){
//                if (val == v.getDeviceId()) {
//                    states.add(e.getVehicleState());
//
//                }
//            }
//
//        }
//        json.put("vehicle_status", states);
//        return objectMapper.writeValueAsString(json);
//    }

}
