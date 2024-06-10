package com.inrix.mds.model.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inrix.mds.model.converter.PropulsionTypeConverter;
import com.inrix.mds.model.enums.PropulsionType;
import com.inrix.mds.model.enums.VehicleType;
import jakarta.persistence.Column;
import jakarta.persistence.Convert;
import jakarta.persistence.Id;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;

public class VehicleResponse {
    @JsonProperty("vehicle_id")
    private String vehicleId;
    @JsonProperty("device_id")
    private UUID deviceId;
    @JsonProperty("provider_id")
    private UUID providerId;
    @JsonProperty("vehicle_type")
    private VehicleType vehicleType;
    @JsonProperty("propulsion_type")
    private List<PropulsionType> propulsionType;
    @JsonProperty("better_capacity")
    private Integer batterCapacity;
    @JsonProperty("maximum_speed")
    private Integer maximumSpeed;

    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(String vehicleId) {
        this.vehicleId = vehicleId;
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

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public List<PropulsionType> getPropulsionType() {
        return propulsionType;
    }

    public void setPropulsionType(List<PropulsionType> propulsionType) {
        this.propulsionType = propulsionType;
    }

    public Integer getBatterCapacity() {
        return batterCapacity;
    }

    public void setBatterCapacity(Integer batterCapacity) {
        this.batterCapacity = batterCapacity;
    }

    public Integer getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(Integer maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }

}
