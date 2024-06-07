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
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@SpringBootApplication
public class MdsApplication {

	public static void main(String[] args) {

		SpringApplication.run(MdsApplication.class, args);
	}

}
