package com.inrix.mds.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;
import org.springframework.lang.Nullable;

import java.sql.Timestamp;
import java.util.UUID;
@Entity
@Table(name = "trip")
public class Trip {

//    Not Required (as of yet)
//   =================================
//    private TripType trip_type;
//    private Map trip_attributes;
//   =================================

    @Id
    @NonNull
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "trip_id")
    private UUID tripId;
//    @NonNull
    @Column(name = "provider_id")
    private UUID providerId;
    @Nullable
    @Column(name = "data_provider_id")
    private UUID dataProviderId;
//    @NonNull
    @Column(name = "device_id")
    private UUID deviceId;
    @Nullable
    @Column(name = "journey_id")
    private UUID journeyId;
//    @NonNull
    @Column(name = "start_time")
    private long startTime;
//    @NonNull
    @Column(name = "end_time")
    private long endTime;
//    @NonNull
    @JoinColumn(name = "start_location", referencedColumnName = "gpsId")
    @OneToOne
    private GPS startLocation;
//    @NonNull
    @JoinColumn(name = "end_location", referencedColumnName = "gpsId")
    @OneToOne
    private GPS endLocation;
//    @NonNull
    private Integer duration;
//    @NonNull
    private Integer distance;
    @ManyToOne(fetch = FetchType.LAZY, optional = true)
    @JoinColumn(name = "telemetry_id")
    private Telemetry telemetry;
    @ManyToOne
    @JoinColumn(name = "event_id")
    @JsonBackReference // <- Indicates Jackson to ignore this side of the relationship
    private Event event;

    @NonNull
    public UUID getTripId() {
        return tripId;
    }

    public void setTripId(@NonNull UUID tripId) {
        this.tripId = tripId;
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
    public UUID getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(@NonNull UUID deviceId) {
        this.deviceId = deviceId;
    }

    @Nullable
    public UUID getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(@Nullable UUID journeyId) {
        this.journeyId = journeyId;
    }

    @NonNull
    public long getStartTime() {
        return startTime;
    }

    public void setStartTime(@NonNull long startTime) {
        this.startTime = startTime;
    }

    @NonNull
    public long getEndTime() {
        return endTime;
    }

    public void setEndTime(@NonNull long endTime) {
        this.endTime = endTime;
    }

    @NonNull
    public GPS getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(@NonNull GPS startLocation) {
        this.startLocation = startLocation;
    }

    @NonNull
    public GPS getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(@NonNull GPS endLocation) {
        this.endLocation = endLocation;
    }

    @NonNull
    public Integer getDuration() {
        return duration;
    }

    public void setDuration(@NonNull Integer duration) {
        this.duration = duration;
    }

    @NonNull
    public Integer getDistance() {
        return distance;
    }

    public void setDistance(@NonNull Integer distance) {
        this.distance = distance;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public void setTelemetry(Telemetry telemetry) {
        this.telemetry = telemetry;
    }

    public Event getEvent() {
        return event;
    }

    public void setEvent(Event event) {
        this.event = event;
    }
}
