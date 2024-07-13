package com.parking.Modules;

import java.util.List;
import java.util.stream.Collectors;

public class ParkingLot extends BaseModel {
    private List<ParkingFloor> parkingFloors;
    private List<Gates> gates;
    private Status status;
    private List<VehicleType> vehicleTypes;
    private ParkingLotStatus parkingLotStatus;

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public void setParkingFloors(List<ParkingFloor> parkingFloors) {
        this.parkingFloors = parkingFloors;
    }

    public List<Gates> getGates() {
        return gates;
    }

    public void setGates(List<Gates> gates) {
        this.gates = gates;
    }

    public List<VehicleType> getVehicleTypes() {
        return vehicleTypes;
    }

    public void setVehicleTypes(List<VehicleType> vehicleTypes) {
        this.vehicleTypes = vehicleTypes;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public ParkingLotStatus getParkingLotStatus() {
        return parkingLotStatus;
    }

    public void setParkingLotStatus(ParkingLotStatus parkingLotStatus) {
        this.parkingLotStatus = parkingLotStatus;
    }

    public int getTotalFloors() {
        return parkingFloors != null ? parkingFloors.size() : 0;
    }

    public int getTotalParkingSpots() {
        if (parkingFloors == null) return 0;
        return parkingFloors.stream().mapToInt(ParkingFloor::getTotalParkingSpots).sum();
    }

    public int getAvailableParkingSpots() {
        if (parkingFloors == null) return 0;
        return parkingFloors.stream().mapToInt(ParkingFloor::getAvailableParkingSpots).sum();
    }

    public List<ParkingSpots> findAvailableSpots() {
        if (parkingFloors == null) return List.of();
        return parkingFloors.stream()
                .flatMap(floor -> floor.findAvailableSpots().stream())
                .collect(Collectors.toList());
    }

    public void validate() {
        if (parkingFloors == null || parkingFloors.isEmpty()) {
            throw new IllegalArgumentException("Parking floors are required");
        }
        if (gates == null || gates.isEmpty()) {
            throw new IllegalArgumentException("Gates are required");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status is required");
        }
        if (parkingLotStatus == null) {
            throw new IllegalArgumentException("Parking lot status is required");
        }
    }

    public void printDetails() {
        System.out.println("Total Floors: " + getTotalFloors());
        System.out.println("Total Spots: " + getTotalParkingSpots());
        System.out.println("Available Spots: " + getAvailableParkingSpots());
        System.out.println("Status: " + status);
        System.out.println("Parking Lot Status: " + parkingLotStatus);
    }

    public void addParkingFloor(ParkingFloor parkingFloor) {
        parkingFloors.add(parkingFloor);
    }

    public void addGate(Gates gate) {
        gates.add(gate);
    }

    public boolean removeParkingFloor(int floorNumber) {
        return parkingFloors.removeIf(floor -> floor.getFloorNumber() == floorNumber);
    }

    public boolean removeGate(int gateNumber) {
        return gates.removeIf(gate -> gate.getGateNumber() == gateNumber);
    }

    public boolean isFull() {
        return getAvailableParkingSpots() == 0;
    }

    public boolean isOperational() {
        return parkingLotStatus == ParkingLotStatus.OPERATIONAL;
    }
}
