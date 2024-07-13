package com.parking.Modules;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingFloor extends BaseModel {
    private int floorNumber;
    private List<ParkingSpots> parkingSpots;
    private Status status;
    private ParkingFloorStatus parkingFloorStatus;

    public int getFloorNumber() {
        return floorNumber;
    }

    public void setFloorNumber(int floorNumber) {
        this.floorNumber = floorNumber;
    }

    public List<ParkingSpots> getParkingSpots() {
        return parkingSpots;
    }

    public void setParkingSpots(List<ParkingSpots> parkingSpots) {
        this.parkingSpots = parkingSpots;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ParkingFloorStatus getParkingFloorStatus() {
        return parkingFloorStatus;
    }

    public void setParkingFloorStatus(ParkingFloorStatus parkingFloorStatus) {
        this.parkingFloorStatus = parkingFloorStatus;
    }

    public int getTotalParkingSpots() {
        return parkingSpots != null ? parkingSpots.size() : 0;
    }

    public int getAvailableParkingSpots() {
        if (parkingSpots == null) return 0;
        return (int) parkingSpots.stream().filter(ParkingSpots::isAvailable).count();
    }

    public List<ParkingSpots> findAvailableSpots() {
        if (parkingSpots == null) return List.of();
        return parkingSpots.stream().filter(ParkingSpots::isAvailable).collect(Collectors.toList());
    }

    public boolean reserveSpot(int spotId) {
        for (ParkingSpots spot : parkingSpots) {
            if (spot.getId() == spotId && spot.isAvailable()) {
                spot.setAvailable(false);
                return true;
            }
        }
        return false;
    }

    public boolean releaseSpot(int spotId) {
        for (ParkingSpots spot : parkingSpots) {
            if (spot.getId() == spotId && !spot.isAvailable()) {
                spot.setAvailable(true);
                return true;
            }
        }
        return false;
    }

    public void validate() {
        if (floorNumber <= 0) {
            throw new IllegalArgumentException("Invalid floor number");
        }
        if (parkingSpots == null || parkingSpots.isEmpty()) {
            throw new IllegalArgumentException("Parking spots are required");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status is required");
        }
        if (parkingFloorStatus == null) {
            throw new IllegalArgumentException("Parking floor status is required");
        }
    }

    public void printDetails() {
        System.out.println("Floor Number: " + floorNumber);
        System.out.println("Total Spots: " + getTotalParkingSpots());
        System.out.println("Available Spots: " + getAvailableParkingSpots());
        System.out.println("Status: " + status);
        System.out.println("Parking Floor Status: " + parkingFloorStatus);
    }
}
