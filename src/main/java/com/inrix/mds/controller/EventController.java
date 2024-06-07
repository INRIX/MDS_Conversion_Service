package com.inrix.mds.controller;

import com.inrix.mds.constants.MDSConstants;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value =  MDSConstants.LIVE_API_VERSION + "/events")
public class EventController {
    @GetMapping("/historical")
    public void eventHistory(){

    }


}
