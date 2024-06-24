package com.inrix.mds.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.model.Vehicle;
import com.inrix.mds.repository.VehicleRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;


import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Service
public class VehicleService {

    @Autowired
    VehicleRepo vehicleRepo;

    public String getVehicle(UUID val) throws JsonProcessingException {
        Map<String, Object> json = new HashMap<>();
        json.put("version", MDSConstants.LIVE_API_VERSION);
        ObjectMapper objectMapper = new ObjectMapper();
        if (val == UUID.fromString("00000000-0000-0000-0000-000000000000")){
            json.put("vehicle",vehicleRepo.findRecentVehicles());
            return objectMapper.writeValueAsString(json);
        }

        for (Vehicle v: vehicleRepo.findAll()){
            if (val == v.getDeviceId()){
                json.put("vehicle", v);
                return objectMapper.writeValueAsString(json);
            }
        }

        return "";
    }
}