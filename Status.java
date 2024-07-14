package com.parking.Modules;

public enum Status {
    FULL,
    EMPTY;

    public String getMessage() {
        switch (this) {
            case FULL:
                return "The parking lot is full.";
            case EMPTY:
                return "The parking lot is empty.";
            default:
                return "Unknown status.";
        }
    }

    public boolean isAvailable() {
        return this == EMPTY;
    }

    public boolean isUnavailable() {
        return this == FULL;
    }

    public int getCode() {
        switch (this) {
            case FULL:
                return 1;
            case EMPTY:
                return 0;
            default:
                return -1;
        }
    }

    public static Status fromCode(int code) {
        switch (code) {
            case 1:
                return FULL;
            case 0:
                return EMPTY;
            default:
                throw new IllegalArgumentException("Unknown code: " + code);
        }
    }

    public void printStatus() {
        System.out.println("Status: " + this.name() + " - " + getMessage());
    }

    public String getDescription() {
        switch (this) {
            case FULL:
                return "Parking lot is at full capacity.";
            case EMPTY:
                return "Parking lot has available spaces.";
            default:
                return "Status description unavailable.";
        }
    }
}
