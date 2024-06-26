package com.inrix.mds.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.inrix.mds.model.converter.EventTypeConverter;
import com.inrix.mds.model.converter.TripIdsConverter;
import com.inrix.mds.model.enums.EventType;
import com.inrix.mds.model.enums.VehicleState;
import jakarta.persistence.*;
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "event_id")
    private UUID eventId;
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
    @Column(name = "vehicle_state")
    private VehicleState vehicleState;
    @NonNull
    @Column(name = "event_types")
    @Convert(converter = EventTypeConverter.class)
    private List<EventType> eventTypes;
    @NonNull
    @Column(name = "timestamp")
    private long timestamp;
    @NonNull
    @Column(name = "battery_percent")
    private Integer batteryPercent;
    @Column(name = "trip_ids")
    @JsonManagedReference
    @Convert(converter = TripIdsConverter.class)
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER, mappedBy = "event")
    private List<Trip> tripIds;

    @ManyToOne
    @JoinColumn(name = "vehicle_id")
    private Vehicle vehicle;

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
    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(@NonNull long timestamp) {
        this.timestamp = timestamp;
    }

    @NonNull
    public Integer getBatteryPercent() {
        return batteryPercent;
    }

    public void setBatteryPercent(@NonNull Integer batteryPercent) {
        this.batteryPercent = batteryPercent;
    }

    public List<Trip> getTripIds() {
        return tripIds;
    }

    public void setTripIds(List<Trip> tripIds) {
        this.tripIds = tripIds;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

}
