package com.parking.Modules;

public enum GateStatus {
    OPEN,
    CLOSED,
    MAINTENANCE,
    OUT_OF_ORDER,
    RESERVED;

    public boolean isOperational() {
        return this == OPEN || this == RESERVED;
    }

    public boolean isUnderMaintenance() {
        return this == MAINTENANCE;
    }

    public boolean isOutOfOrder() {
        return this == OUT_OF_ORDER;
    }

    public boolean isReserved() {
        return this == RESERVED;
    }

    public String getDescription() {
        switch (this) {
            case OPEN:
                return "The gate is open and operational.";
            case CLOSED:
                return "The gate is closed.";
            case MAINTENANCE:
                return "The gate is currently under maintenance.";
            case OUT_OF_ORDER:
                return "The gate is out of order and not operational.";
            case RESERVED:
                return "The gate is reserved for a special purpose.";
            default:
                return "Unknown gate status.";
        }
    }

    public GateStatus getNextStatus() {
        switch (this) {
            case OPEN:
                return CLOSED;
            case CLOSED:
                return MAINTENANCE;
            case MAINTENANCE:
                return OUT_OF_ORDER;
            case OUT_OF_ORDER:
                return RESERVED;
            case RESERVED:
                return OPEN;
            default:
                return OPEN;
        }
    }

    public static void demonstrateUsage() {
        for (GateStatus status : GateStatus.values()) {
            System.out.println("Status: " + status);
            System.out.println("Description: " + status.getDescription());
            System.out.println("Is Operational: " + status.isOperational());
            System.out.println("Is Under Maintenance: " + status.isUnderMaintenance());
            System.out.println("Is Out of Order: " + status.isOutOfOrder());
            System.out.println("Is Reserved: " + status.isReserved());
            System.out.println("Next Status: " + status.getNextStatus());
            System.out.println();
        }
    }

    public static void main(String[] args) {
        demonstrateUsage();
    }
}
