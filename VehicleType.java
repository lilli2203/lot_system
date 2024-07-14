package com.parking.Modules;

public enum VehicleType {
    TWO_WHEELER,
    FOUR_WHEELER,
    THREE_WHEELER,
    ELECTRIC_TWO_WHEELER,
    ELECTRIC_FOUR_WHEELER,
    ELECTRIC_THREE_WHEELER;

    public int getNumberOfWheels() {
        switch (this) {
            case TWO_WHEELER:
            case ELECTRIC_TWO_WHEELER:
                return 2;
            case FOUR_WHEELER:
            case ELECTRIC_FOUR_WHEELER:
                return 4;
            case THREE_WHEELER:
            case ELECTRIC_THREE_WHEELER:
                return 3;
            default:
                return 0;
        }
    }

    public boolean isElectric() {
        switch (this) {
            case ELECTRIC_TWO_WHEELER:
            case ELECTRIC_FOUR_WHEELER:
            case ELECTRIC_THREE_WHEELER:
                return true;
            default:
                return false;
        }
    }

    public int getMaxSpeed() {
        switch (this) {
            case TWO_WHEELER:
                return 100;
            case FOUR_WHEELER:
                return 200;
            case THREE_WHEELER:
                return 80;
            case ELECTRIC_TWO_WHEELER:
                return 80;
            case ELECTRIC_FOUR_WHEELER:
                return 150;
            case ELECTRIC_THREE_WHEELER:
                return 60;
            default:
                return 0;
        }
    }

    public String getDescription() {
        switch (this) {
            case TWO_WHEELER:
                return "Standard two-wheeled vehicle.";
            case FOUR_WHEELER:
                return "Standard four-wheeled vehicle.";
            case THREE_WHEELER:
                return "Standard three-wheeled vehicle.";
            case ELECTRIC_TWO_WHEELER:
                return "Electric two-wheeled vehicle.";
            case ELECTRIC_FOUR_WHEELER:
                return "Electric four-wheeled vehicle.";
            case ELECTRIC_THREE_WHEELER:
                return "Electric three-wheeled vehicle.";
            default:
                return "Unknown vehicle type.";
        }
    }
}
