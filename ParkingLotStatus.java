package com.parking.Modules;

public enum ParkingLotStatus {
    Open("The parking lot is open and available for parking."),
    Closed("The parking lot is closed and not available for parking."),
    Full("The parking lot is full and cannot accommodate more vehicles."),
    UnderMaintenance("The parking lot is currently under maintenance.");

    private final String description;

    ParkingLotStatus(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }

    public static ParkingLotStatus fromString(String status) {
        for (ParkingLotStatus s : ParkingLotStatus.values()) {
            if (s.name().equalsIgnoreCase(status)) {
                return s;
            }
        }
        throw new IllegalArgumentException("Unknown status: " + status);
    }

    @Override
    public String toString() {
        return this.name() + ": " + this.getDescription();
    }
}
