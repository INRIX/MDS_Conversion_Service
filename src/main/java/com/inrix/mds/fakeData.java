package com.inrix.mds;

import com.inrix.mds.model.*;
import com.inrix.mds.model.enums.EventType;
import com.inrix.mds.model.enums.PropulsionType;
import com.inrix.mds.model.enums.VehicleState;
import com.inrix.mds.model.enums.VehicleType;
import com.inrix.mds.repository.*;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
@Service
public class fakeData {
    private final EventRepo eventRepository;
    private final TelemetryRepo telemetryRepository;
    private final TripRepo tripRepository;
    private final VehicleRepo vehicleRepository;
    private final GPSRepo gpsRepository;

    @Autowired
    public fakeData(EventRepo eventRepository, TelemetryRepo telemetryRepository, TripRepo tripRepository, VehicleRepo vehicleRepository, GPSRepo GPSRepository) {
        this.eventRepository = eventRepository;
        this.telemetryRepository = telemetryRepository;
        this.tripRepository = tripRepository;
        this.vehicleRepository = vehicleRepository;
        this.gpsRepository = GPSRepository;
    }

    @PostConstruct
    @Transactional
    public void seedData() {

        Event event = new Event();
//        UUID u = UUID.randomUUID();
//        event.setEventId(u);
        event.setDeviceId(UUID.randomUUID());
        event.setProviderId(UUID.randomUUID());
        event.setDataProviderId(UUID.randomUUID());
        event.setVehicleState(VehicleState.reserved);
        List<EventType> eventTypes = new ArrayList<>();
        eventTypes.add(EventType.maintenance);
        eventTypes.add(EventType.trip_start);
        event.setEventTypes(eventTypes);
        event.setTimestamp(1718541688133L);
        event.setBatteryPercent(77);

        Trip t = new Trip();
        t.setDuration(2222);
//        t.setTripId(UUID.randomUUID());
        t.setEvent(event);

        List<Trip> aa = new ArrayList<>();
        aa.add(t);
        event.setTripIds(aa);


        List<Event> eee = new ArrayList<>();
        eee.add(event);
        Vehicle v = new Vehicle();
        v.setVehicleId("TESTING");
        v.setBatterCapacity(100);
        v.setMaximumSpeed(1000);
        v.setProviderId(UUID.randomUUID());
        v.setVehicleType(VehicleType.delivery_robot);
        v.setDeviceId(UUID.randomUUID());
        List<PropulsionType> pp = new ArrayList<>();
        pp.add(PropulsionType.human);
        v.setPropulsionType(pp);
        v.setEvents(eee);
        vehicleRepository.save(v);
        event.setVehicle(v);

        eventRepository.save(event);
        tripRepository.save(t);




//        event.setTripIds(aa);


    }
//        Event event = new Event();
//        event.setEventId(UUID.randomUUID());
//        event.setDeviceId(UUID.randomUUID());
//        event.setProviderId(UUID.randomUUID());
//        event.setDataProviderId(UUID.randomUUID());
//        event.setVehicleState(VehicleState.reserved);
//        List<EventType> eventTypes = new ArrayList<>();
//        eventTypes.add(EventType.maintenance);
//        eventTypes.add(EventType.trip_start);
//        event.setEventTypes(eventTypes);
//        event.setTimestamp(new Timestamp(System.currentTimeMillis()));
//        event.setBatteryPercent(77);
//        event.setTripIds(List.of(UUID.randomUUID(), UUID.randomUUID()));
//        eventRepository.save(event);
//
//        GPS G = new GPS();
//        G.setAltitude(1.222);
//        G.setHeading(1.223);
//        G.setLat(2.1456);
//        G.setLng(1.2456);
//        G.setSatellites(4);
//        G.setSpeed(12.4F);
//        G.setHorizontal_accuracy(12F);
//        G.setVertical_accuracy(6F);
//        GPS gps = gpsRepository.save(G);
//
//
//        Telemetry telemetry = new Telemetry();
//        telemetry.setTelemetryId(UUID.randomUUID());
//        telemetry.setDeviceId(UUID.randomUUID());
//        telemetry.setProviderId(UUID.randomUUID());
//        telemetry.setDataProviderId(UUID.randomUUID());
//        telemetry.setTimestamp(new Timestamp(System.currentTimeMillis()));
//        telemetry.setTripIds(List.of(UUID.randomUUID(), UUID.randomUUID()));
//        telemetry.setJourneyId(UUID.randomUUID());
//        telemetry.setLocation(gps);
//        telemetry.setBatteryPercent(88);
//        telemetryRepository.save(telemetry);
//
//
//        Trip trip = new Trip();
//        trip.setTripId(UUID.randomUUID());
//        trip.setProviderId(UUID.randomUUID());
//        trip.setDataProviderId(UUID.randomUUID());
//        trip.setDeviceId(UUID.randomUUID());
//        trip.setJourneyId(UUID.randomUUID());
//        trip.setStartTime(new Timestamp(System.currentTimeMillis()));
//        trip.setEndTime(new Timestamp(System.currentTimeMillis()));
//        trip.setStartLocation(gps);
//        trip.setEndLocation(gps);
//        trip.setDuration(500);
//        trip.setDistance(800);
//        tripRepository.save(trip);
//
//        Vehicle vehicle = new Vehicle();
//        vehicle.setVehicleId(UUID.randomUUID().toString());
//        vehicle.setDeviceId(UUID.randomUUID());
//        vehicle.setProviderId(UUID.randomUUID());
//        vehicle.setVehicleType(VehicleType.bicycle);
//        List<PropulsionType> propulsionTypes = new ArrayList<>();
//        propulsionTypes.add(PropulsionType.human);
//        propulsionTypes.add(PropulsionType.electric);
//        vehicle.setPropulsionType(propulsionTypes);
//        vehicle.setBatterCapacity(2300);
//        vehicle.setMaximumSpeed(100);
//        vehicleRepository.save(vehicle);
//    }

}
