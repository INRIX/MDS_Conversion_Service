package com.inrix.mds.model;

import com.inrix.mds.model.converter.EventTypeConverter;
import com.inrix.mds.model.converter.TripIdsConverter;
import com.inrix.mds.model.enums.EventType;
import com.inrix.mds.model.enums.VehicleState;
import jakarta.persistence.*;
import org.hibernate.annotations.Type;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "event")
public class Event {
    @Id
    @NonNull
    @Column(name = "event_id", columnDefinition = "VARCHAR(36)")  // USE uuid for POSTGRES
    private UUID eventId;
    @NonNull
    @Column(name = "device_id", columnDefinition = "VARCHAR(36)") // USE uuid for POSTGRES
    private UUID deviceId;
    @NonNull
    @Column(name = "provider_id", columnDefinition = "BINARY(16)") // USE uuid for POSTGRES
    private UUID providerId;
    @Nullable
    @Column(name = "data_provider_id", columnDefinition = "BINARY(16)")
    private UUID dataProviderId;
    @NonNull
    @Column(name = "vehicle_state")
    private VehicleState vehicleState;
    @NonNull
    @Column(name = "event_types")
    @Convert(converter = EventTypeConverter.class)
    private List<EventType> eventTypes;
    @NonNull
    @Column(name = "timestamp", columnDefinition = "TIMESTAMP")
    private Timestamp timestamp;
    @NonNull
    @Column(name = "battery_percent")
    private Integer batteryPercent;
    @Column(name = "trip_ids")
    @Convert(converter = TripIdsConverter.class)
    private List<UUID> tripIds;

    @PrePersist
    @PreUpdate
    private void validateTripIds() {
        if (eventTypes.contains(EventType.trip_start) ||
                eventTypes.contains(EventType.trip_end) ||
                eventTypes.contains(EventType.trip_cancel) ||
                eventTypes.contains(EventType.trip_enter_jurisdiction) ||
                eventTypes.contains(EventType.trip_leave_jurisdiction)) {
            if (tripIds == null || tripIds.isEmpty()) {
                throw new IllegalStateException("Trip IDs required!");
            }
        }
    }

    @NonNull
    public UUID getEventId() {
        return eventId;
    }

    public void setEventId(@NonNull UUID eventId) {
        this.eventId = eventId;
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
    public VehicleState getVehicleState() {
        return vehicleState;
    }

    public void setVehicleState(@NonNull VehicleState vehicleState) {
        this.vehicleState = vehicleState;
    }

    @NonNull
    public List<EventType> getEventTypes() {
        return eventTypes;
    }

    public void setEventTypes(@NonNull List<EventType> eventTypes) {
        this.eventTypes = eventTypes;
    }

    @NonNull
    public Timestamp getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NonNull Timestamp timestamp) {
        this.timestamp = timestamp;
    }

    @NonNull
    public Integer getBatteryPercent() {
        return batteryPercent;
    }

    public void setBatteryPercent(@NonNull Integer batteryPercent) {
        this.batteryPercent = batteryPercent;
    }

    public List<UUID> getTripIds() {
        return tripIds;
    }

    public void setTripIds(List<UUID> tripIds) {
        this.tripIds = tripIds;
    }

}
