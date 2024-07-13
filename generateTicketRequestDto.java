package com.parking.Dto;

import com.parking.Modules.VehicleType;

public class generateTicketRequestDto {
    private Long gateId;
    private VehicleType vehicleType;
    private String vehicleNumber;
    private String ownerName;

    public generateTicketRequestDto() {}

    public generateTicketRequestDto(Long gateId, VehicleType vehicleType, String vehicleNumber, String ownerName) {
        this.gateId = gateId;
        this.vehicleType = vehicleType;
        this.vehicleNumber = vehicleNumber;
        this.ownerName = ownerName;
    }

    public Long getGateId() {
        return gateId;
    }

    public void setGateId(Long gateId) {
        if (gateId == null || gateId <= 0) {
            throw new IllegalArgumentException("Gate ID must be a positive number.");
        }
        this.gateId = gateId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        if (vehicleType == null) {
            throw new IllegalArgumentException("Vehicle type cannot be null.");
        }
        this.vehicleType = vehicleType;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        if (vehicleNumber == null || vehicleNumber.trim().isEmpty()) {
            throw new IllegalArgumentException("Vehicle number cannot be empty.");
        }
        this.vehicleNumber = vehicleNumber;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        if (ownerName == null || ownerName.trim().isEmpty()) {
            throw new IllegalArgumentException("Owner name cannot be empty.");
        }
        this.ownerName = ownerName;
    }

    public boolean isValid() {
        return gateId != null && gateId > 0 &&
               vehicleType != null &&
               vehicleNumber != null && !vehicleNumber.trim().isEmpty() &&
               ownerName != null && !ownerName.trim().isEmpty();
    }

    @Override
    public String toString() {
        return "generateTicketRequestDto{" +
               "gateId=" + gateId +
               ", vehicleType=" + vehicleType +
               ", vehicleNumber='" + vehicleNumber + '\'' +
               ", ownerName='" + ownerName + '\'' +
               '}';
    }
}
