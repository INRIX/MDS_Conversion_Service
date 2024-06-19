package com.inrix.mds;

import com.inrix.mds.model.*;
import com.inrix.mds.model.enums.EventType;
import com.inrix.mds.model.enums.PropulsionType;
import com.inrix.mds.model.enums.VehicleState;
import com.inrix.mds.model.enums.VehicleType;
import com.inrix.mds.repository.EventRepo;
import com.inrix.mds.repository.TelemetryRepo;
import com.inrix.mds.repository.TripRepo;
import com.inrix.mds.repository.VehicleRepo;
import jakarta.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.time.Instant;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class MdsApplication implements CommandLineRunner {
	@Autowired
	EventRepo eventRepo;


	public static void main(String[] args) {

		SpringApplication.run(MdsApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		// Now you can perform your logic with eventRepo here
		Iterable<Event> events = eventRepo.findAll();
		for (Event event : events) {
			Instant instant = Instant.ofEpochMilli(event.getTimestamp());
			Instant plusOneHour = instant.plus(1, ChronoUnit.HOURS);
			// Process each event as needed
			System.out.print("TIME:");
			System.out.println(instant);
		}
	}

}
