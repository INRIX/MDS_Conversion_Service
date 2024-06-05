package com.inrix.mds.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class GPS {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int gpsId;
    private Double lat;
    private Double lng;
    private Double altitude;
    private Double heading;
    private Float speed;
    private Float horizontal_accuracy;
    private Float vertical_accuracy;
    private Integer satellites;

    public int getGpsId() {
        return gpsId;
    }

    public void setGpsId(int gpsId) {
        this.gpsId = gpsId;
    }

    public Double getLat() {
        return lat;
    }

    public void setLat(Double lat) {
        this.lat = lat;
    }

    public Double getLng() {
        return lng;
    }

    public void setLng(Double lng) {
        this.lng = lng;
    }

    public Double getAltitude() {
        return altitude;
    }

    public void setAltitude(Double altitude) {
        this.altitude = altitude;
    }

    public Double getHeading() {
        return heading;
    }

    public void setHeading(Double heading) {
        this.heading = heading;
    }

    public Float getSpeed() {
        return speed;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public Float getHorizontal_accuracy() {
        return horizontal_accuracy;
    }

    public void setHorizontal_accuracy(Float horizontal_accuracy) {
        this.horizontal_accuracy = horizontal_accuracy;
    }

    public Float getVertical_accuracy() {
        return vertical_accuracy;
    }

    public void setVertical_accuracy(Float vertical_accuracy) {
        this.vertical_accuracy = vertical_accuracy;
    }

    public Integer getSatellites() {
        return satellites;
    }

    public void setSatellites(Integer satellites) {
        this.satellites = satellites;
    }
}
