package com.inrix.mds.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inrix.mds.model.converter.EventTypeConverter;
import com.inrix.mds.model.converter.TripIdsConverter;
import com.inrix.mds.model.enums.EventType;
import com.inrix.mds.model.enums.VehicleState;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;

public class EventResponse {
    @JsonProperty("event_id")
    private UUID eventId;
    @JsonProperty("device_id")
    private UUID deviceId;
    @JsonProperty("provider_id")
    private UUID providerId;
    @JsonProperty("data_provider_id")
    private UUID dataProviderId;
    @JsonProperty("vehicle_state")
    private VehicleState vehicleState;
    @JsonProperty("event_types")
    private List<EventType> eventTypes;
    @JsonProperty
    private Timestamp timestamp;
    @JsonProperty("battery_percent")
    private Integer batteryPercent;
    @JsonProperty("trip_ids")
    private List<UUID> tripIds;

    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(UUID eventId) {
        this.eventId = eventId;
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

    public VehicleState getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(VehicleState vehicleState) {
        this.vehicleState = vehicleState;
    }

    public List<EventType> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(List<EventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    public Integer getBatteryPercent() {
        return batteryPercent;
    }

    public void setBatteryPercent(Integer batteryPercent) {
        this.batteryPercent = batteryPercent;
    }

    public List<UUID> getTripIds() {
        return tripIds;
    }

    public void setTripIds(List<UUID> tripIds) {
        this.tripIds = tripIds;
    }
}
