package com.inrix.mds.repository;

import com.inrix.mds.model.Vehicle;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, String> {
    @Query(value = "SELECT * FROM vehicle WHERE timestamp_column >= EXTRACT(EPOCH FROM NOW() - INTERVAL '30 days') * 1000", nativeQuery = true)
    List<Vehicle> findRecentVehicles();
}
