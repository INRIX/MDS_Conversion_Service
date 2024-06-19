package com.inrix.mds.model;

import com.inrix.mds.model.converter.TripIdsConverter;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name="telemetry")
public class Telemetry {
    @Id
    @NonNull
    @Column(name = "telemetry_id")
    private UUID telemetryId;
    @NonNull
    @Column(name = "device_id")
    private UUID deviceId;
    @NonNull
    @Column(name = "provider_id")
    private UUID providerId;
    @Nullable
    @Column(name = "data_provider_id")
    private UUID dataProviderId;
    @NonNull
    @Column(name = "timestamp")
    private long timestamp;
//    @NonNull
    @Column(name = "trip_ids")
    @Convert(converter = TripIdsConverter.class)
    @JoinColumn(name = "trip_id")
    private List<Trip> tripIds;
    @NonNull
    @Column(name = "journey_id")
    private UUID journeyId;
    @NonNull
    @OneToOne
    @JoinColumn(name = "location", referencedColumnName = "gpsId")
    private GPS location;
    @NonNull
    @Column(name = "battery_percent")
    private Integer batteryPercent;

    @NonNull
    public UUID getTelemetryId() {
        return telemetryId;
    }

    public void setTelemetryId(@NonNull UUID telemetryId) {
        this.telemetryId = telemetryId;
    }

    @NonNull
    public UUID getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(@NonNull UUID deviceId) {
        this.deviceId = deviceId;
    }

    @NonNull
    public UUID getProviderId() {
        return providerId;
    }

    public void setProviderId(@NonNull UUID providerId) {
        this.providerId = providerId;
    }

    @Nullable
    public UUID getDataProviderId() {
        return dataProviderId;
    }

    public void setDataProviderId(@Nullable UUID dataProviderId) {
        this.dataProviderId = dataProviderId;
    }

    @NonNull
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NonNull long timestamp) {
        this.timestamp = timestamp;
    }

    @NonNull
    public List<Trip> getTripIds() {
        return tripIds;
    }

    public void setTripIds(@NonNull List<Trip> tripIds) {
        this.tripIds = tripIds;
    }

    @NonNull
    public UUID getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(@NonNull UUID journeyId) {
        this.journeyId = journeyId;
    }

    @NonNull
    public GPS getLocation() {
        return location;
    }

    public void setLocation(@NonNull GPS location) {
        this.location = location;
    }

    @NonNull
    public Integer getBatteryPercent() {
        return batteryPercent;
    }

    public void setBatteryPercent(@NonNull Integer batteryPercent) {
        this.batteryPercent = batteryPercent;
    }

}
