package com.inrix.mds.constants;

public enum MDSType {
    EVENT(1),
    TRIP(2),
    TELEMETRY(3),
    VEHICLE(4);

private final int val;

    MDSType(int val) {
        this.val = val;
    }

    public static MDSType fromId(int id) {
        for (MDSType type : values()) {
            if (type.val == id) {
                return type;
            }
        }
        throw new IllegalArgumentException("Invalid MDS type ID: " + id);
    }

}
