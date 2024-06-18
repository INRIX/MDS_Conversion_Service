package com.inrix.mds.controller;

import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.model.Event;
import com.inrix.mds.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value =  MDSConstants.LIVE_API_VERSION + "/events")
public class EventController {
    @Autowired
    private EventRepo eventRepo;

    @GetMapping("/historical")
    public List<Event> eventHistory(){
        return eventRepo.findAll();

    }


}
