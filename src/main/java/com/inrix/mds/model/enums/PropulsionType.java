package com.inrix.mds.model.enums;

public enum PropulsionType {
    human(1),
    electric_assist(2),
    electric(3),
    combustion(4),
    combustion_diesel(5),
    hybrid(6),
    hydrogen_fuel_cell(7),
    plug_in_hybrid(8);

    private final int val;

    PropulsionType(int val) {
        this.val = val;
    }
}
