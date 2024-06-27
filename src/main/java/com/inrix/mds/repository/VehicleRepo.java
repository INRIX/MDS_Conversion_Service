package com.inrix.mds.repository;

import com.inrix.mds.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, String> {
    Vehicle findVehicleByDeviceId(UUID deviceId);
}
