package com.inrix.mds.repository;

import com.inrix.mds.model.Event;
import com.inrix.mds.model.Telemetry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;
@Repository
public interface TelemetryRepo extends JpaRepository<Telemetry, UUID> {
    List<Telemetry> findByTimestampGreaterThanEqualAndTimestampLessThanEqual(long start, long end);

}
