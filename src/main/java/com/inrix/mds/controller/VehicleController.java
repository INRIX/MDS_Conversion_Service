package com.inrix.mds.controller;

import com.inrix.mds.constants.MDSConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = MDSConstants.LIVE_API_VERSION + "/vehicles")
public class VehicleController {

    @GetMapping(value = "/status")
    public void vehicleStatus (@RequestParam(required = false) UUID deviceId){}
}
