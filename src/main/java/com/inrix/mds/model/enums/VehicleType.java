package com.inrix.mds.model.enums;

public enum VehicleType {
    bicycle(1),
    bus(2),
    cargo_bicycle(3),
    car(4),
    delivery_robot(5),
    moped(6),
    motorcycle(7),
    scooter_standing(8),
    scooter_seated(9),
    truck(10),
    other(11);
    private final int val;

    VehicleType(int val) {
        this.val = val;
    }
}
