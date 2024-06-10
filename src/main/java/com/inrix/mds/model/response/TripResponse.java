package com.inrix.mds.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inrix.mds.model.GPS;

import java.sql.Timestamp;
import java.util.UUID;

public class TripResponse {
    @JsonProperty("trip_id")
    private UUID tripId;
    @JsonProperty("provider_id")
    private UUID providerId;

    @JsonProperty("data_provider_id")
    private UUID dataProviderId;
    @JsonProperty("device_id")
    private UUID deviceId;
    @JsonProperty("journey_id")
    private UUID journeyId;
    @JsonProperty
    private Timestamp startTime;
    @JsonProperty
    private Timestamp endTime;
    @JsonProperty
    private GPS startLocation;
    @JsonProperty
    private GPS endLocation;
    @JsonProperty
    private Integer duration;
    @JsonProperty
    private Integer distance;

    public UUID getTripId() {
        return tripId;
    }

    public void setTripId(UUID tripId) {
        this.tripId = tripId;
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

    public UUID getDeviceId() {
        return deviceId;
    }

    public void setDeviceId(UUID deviceId) {
        this.deviceId = deviceId;
    }

    public UUID getJourneyId() {
        return journeyId;
    }

    public void setJourneyId(UUID journeyId) {
        this.journeyId = journeyId;
    }

    public Timestamp getStartTime() {
        return startTime;
    }

    public void setStartTime(Timestamp startTime) {
        this.startTime = startTime;
    }

    public Timestamp getEndTime() {
        return endTime;
    }

    public void setEndTime(Timestamp endTime) {
        this.endTime = endTime;
    }

    public GPS getStartLocation() {
        return startLocation;
    }

    public void setStartLocation(GPS startLocation) {
        this.startLocation = startLocation;
    }

    public GPS getEndLocation() {
        return endLocation;
    }

    public void setEndLocation(GPS endLocation) {
        this.endLocation = endLocation;
    }

    public Integer getDuration() {
        return duration;
    }

    public void setDuration(Integer duration) {
        this.duration = duration;
    }

    public Integer getDistance() {
        return distance;
    }

    public void setDistance(Integer distance) {
        this.distance = distance;
    }
}
