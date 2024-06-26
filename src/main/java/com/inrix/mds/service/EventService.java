package com.inrix.mds.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.inrix.mds.constants.MDSConstants;
import com.inrix.mds.exception.ParamErrors;
import com.inrix.mds.model.Event;
import com.inrix.mds.model.response.ResponseWrapper;
import com.inrix.mds.repository.EventRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class EventService {
    @Autowired
    EventRepo eventRepo;
    public ResponseWrapper getRecent(Long start, Long end) {
//        List<Event> events = new ArrayList<>();

        if (start == null){
            throw new ParamErrors("start_time cannot be null.");
        }
        if (end == null){
            throw new ParamErrors("end_time cannot be null.");
        }
        ResponseWrapper responseWrapper = new ResponseWrapper();
        long currentTime = System.currentTimeMillis();
        long twoWeeks = currentTime - ChronoUnit.WEEKS.getDuration().toMillis() * 2;
        if (start < twoWeeks || end < twoWeeks){
            throw new ParamErrors("Value is greater than 2 weeks before the time of the request.");
        }
//        for (Event e: eventRepo.findAll()){
//            if (e.getTimestamp()>= start && e.getTimestamp() < end){
//                events.add(e);
//            }
//        }
        responseWrapper.setData(eventRepo.findByTimestampGreaterThanEqualAndTimestampLessThan(start,end));

        return responseWrapper;
    }
}
