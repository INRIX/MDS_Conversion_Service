package com.inrix.mds.repository;

import com.inrix.mds.model.Vehicle;
import com.inrix.mds.model.enums.VehicleState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, String> {
    Vehicle findVehicleByDeviceId(UUID deviceId);

//    @Query("SELECT DISTINCT e.vehicle FROM Event e WHERE e.vehicleState IN :states")
//    List<Vehicle> findVehiclesByStates(@Param("states") List<VehicleState> states);

    @Query("SELECT DISTINCT v FROM Vehicle v " +
            "LEFT JOIN v.events e " +
            "WHERE " +
            "(e IS NULL OR e.timestamp >= :ninetyMinutesAgo AND (e.vehicleState = :elsewhere OR e.vehicleState = :removed)) " +
            "OR v IN (SELECT e.vehicle FROM Event e WHERE e.vehicleState IN :states)")
    List<Vehicle> findDistinctVehicles(
            @Param("ninetyMinutesAgo") long ninetyMinutesAgo,
            @Param("elsewhere") VehicleState elsewhere,
            @Param("removed") VehicleState removed,
            @Param("states") List<VehicleState> states
    );
}

