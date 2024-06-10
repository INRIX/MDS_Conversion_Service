package com.inrix.mds.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inrix.mds.model.GPS;
import com.inrix.mds.model.converter.TripIdsConverter;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class TelemetryResponse {
    @JsonProperty("telemetry_id")
    private UUID telemetryId;
    @JsonProperty("device_id")
    private UUID deviceId;
    @JsonProperty("provider_id")
    private UUID providerId;
    @JsonProperty("data_provider_id")
    private UUID dataProviderId;
    @JsonProperty
    private Timestamp timestamp;
    @JsonProperty("trip_ids")
    private List<UUID> tripIds;
    @JsonProperty("journey_id")
    private UUID journeyId;
    @JsonProperty
    private GPS location;
    @JsonProperty("battery_percent")
    private Integer batteryPercent;

    public UUID getTelemetryId() {
        return telemetryId;
    }

    public void setTelemetryId(UUID telemetryId) {
        this.telemetryId = telemetryId;
    }

    public UUID getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
        this.deviceId = deviceId;
    }

    public UUID getProviderId() {
        return providerId;
    }

    public void setProviderId(UUID providerId) {
        this.providerId = providerId;
    }

    public UUID getDataProviderId() {
        return dataProviderId;
    }

    public void setDataProviderId(UUID dataProviderId) {
        this.dataProviderId = dataProviderId;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public List<UUID> getTripIds() {
        return tripIds;
    }

    public void setTripIds(List<UUID> tripIds) {
        this.tripIds = tripIds;
    }

    public UUID getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(UUID journeyId) {
        this.journeyId = journeyId;
    }

    public GPS getLocation() {
        return location;
    }

    public void setLocation(GPS location) {
        this.location = location;
    }

    public Integer getBatteryPercent() {
        return batteryPercent;
    }

    public void setBatteryPercent(Integer batteryPercent) {
        this.batteryPercent = batteryPercent;
    }
}
