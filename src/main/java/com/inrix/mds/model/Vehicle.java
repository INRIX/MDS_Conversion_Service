package com.inrix.mds.model;

import com.inrix.mds.model.converter.PropulsionTypeConverter;
import com.inrix.mds.model.enums.PropulsionType;
import com.inrix.mds.model.enums.VehicleType;
import jakarta.persistence.*;
import org.springframework.data.relational.core.sql.In;
import org.springframework.lang.NonNull;

import java.util.List;
import java.util.UUID;
@Entity
@Table(name = "vehicle")
public class Vehicle {

    @Id
    @NonNull
    @Column(name = "vehicle_id")
    private String vehicleId;
    @NonNull
    @Column(name = "device_id")
    private UUID deviceId;
    @NonNull
    @Column(name = "provider_id")
    private UUID providerId;
    @NonNull
    @Column(name = "vehicle_type")
    private VehicleType vehicleType;
    @NonNull
    @Column(name = "propulsion_type")
    @Convert(converter = PropulsionTypeConverter.class)
    private List<PropulsionType> propulsionType;
    @NonNull
    @Column(name = "battery_capacity")
    private Integer batterCapacity;
    @NonNull
    @Column(name = "maximum_speed")
    private Integer maximumSpeed;

    @OneToMany(mappedBy = "vehicle")
    private List<Event> events;

    @NonNull
    public String getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(@NonNull String vehicleId) {
        this.vehicleId = vehicleId;
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

    @NonNull
    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(@NonNull VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    @NonNull
    public List<PropulsionType> getPropulsionType() {
        return propulsionType;
    }

    public void setPropulsionType(@NonNull List<PropulsionType> propulsionType) {
        this.propulsionType = propulsionType;
    }

    @NonNull
    public Integer getBatterCapacity() {
        return batterCapacity;
    }

    public void setBatterCapacity(@NonNull Integer batterCapacity) {
        this.batterCapacity = batterCapacity;
    }

    @NonNull
    public Integer getMaximumSpeed() {
        return maximumSpeed;
    }

    public void setMaximumSpeed(@NonNull Integer maximumSpeed) {
        this.maximumSpeed = maximumSpeed;
    }
    public List<Event> getEvents() {
        return events;
    }

    public void setEvents(List<Event> events) {
        this.events = events;
    }
}
