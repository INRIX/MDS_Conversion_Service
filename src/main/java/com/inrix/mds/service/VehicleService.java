package com.inrix.mds.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.model.Event;
import com.inrix.mds.model.Vehicle;
import com.inrix.mds.model.enums.VehicleState;
import com.inrix.mds.model.response.ResponseWrapper;
import com.inrix.mds.repository.EventRepo;
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

    @Autowired
    EventRepo eventRepo;

//    public ResponseWrapper getVehicle() {
//        List<Vehicle> vehicle = new ArrayList<>();
//        ResponseWrapper responseWrapper = new ResponseWrapper();
//        for (Vehicle v : vehicleRepo.findAll()) {
//            if (v.getEvents().getLast().getTimestamp() >= (Instant.now().minus(Duration.ofDays(30)).toEpochMilli())) {
//                vehicle.add(v);
//            }
//        }
//        responseWrapper.setData("vehicle: " + vehicle);
//        return responseWrapper;
//    }

    public ResponseWrapper getVehicle(UUID val) {
        ResponseWrapper responseWrapper = new ResponseWrapper();
        if (val == null){
            List<Vehicle> vehicle = new ArrayList<>();
            for (Vehicle v : vehicleRepo.findAll()) {
                if (v.getEvents().getLast().getTimestamp() >= (Instant.now().minus(Duration.ofDays(30)).toEpochMilli())) {
                    vehicle.add(v);
                }
            }
            responseWrapper.setData(vehicle);
            return responseWrapper;
        }
//        List<Vehicle> vehicle = new ArrayList<>();
//
//        for (Vehicle v : vehicleRepo.findAll()) {
//            if (val == v.getDeviceId()) {
//                vehicle.add(v);
//            }
//        }
        responseWrapper.setData(vehicleRepo.findVehicleByDeviceId(val));
        return responseWrapper;
    }

    public ResponseWrapper getVehicleStatus(UUID val) {
        List<VehicleState> targetStates = Arrays.asList(
                VehicleState.reserved,
                VehicleState.on_trip,
                VehicleState.stopped,
                VehicleState.available,
                VehicleState.non_operational,
                VehicleState.non_contactable
        );
//        List<Vehicle> vehicles = new ArrayList<>();
        ResponseWrapper responseWrapper = new ResponseWrapper();
        if (val == null) {
            long ninetyMinutesAgo = Instant.now().minus(Duration.ofMinutes(90)).toEpochMilli();
            responseWrapper.setData(vehicleRepo.findDistinctVehicles(ninetyMinutesAgo, VehicleState.elsewhere, VehicleState.removed, targetStates));
            return responseWrapper;
//            for (Vehicle vehicle : vehicleRepo.findAll()) {
//                if ((vehicle.getEvents().getLast().getTimestamp() >= Instant.now().minus(Duration.ofMinutes(90)).toEpochMilli())
//                        && (vehicle.getEvents().getLast().getVehicleState() == VehicleState.elsewhere ||
//                        vehicle.getEvents().getLast().getVehicleState() == VehicleState.removed)) {
//                    vehicles.add(vehicle);
//                    continue;
//                }
//                for (Event event : eventRepo.findAll()) {
//                    if (event.getVehicleState() == VehicleState.reserved ||
//                            event.getVehicleState() == VehicleState.on_trip ||
//                            event.getVehicleState() == VehicleState.stopped ||
//                            event.getVehicleState() == VehicleState.available ||
//                            event.getVehicleState() == VehicleState.non_operational ||
//                            event.getVehicleState() == VehicleState.non_contactable) {
//                        vehicles.add(vehicle);
//                        break;
//                    }
//                }
//            }
        }
        responseWrapper.setData(vehicleRepo.findVehicleByDeviceId(val));
//        responseWrapper.setData(vehicles);
        return responseWrapper;
    }

}
