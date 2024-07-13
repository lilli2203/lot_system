package com.parking.Modules;

public class Gates extends BaseModel {
    private int gateNumber;
    private Status status;
    private GateStatus gateStatus;
    private Operator operator;
    private GateType gateType;

    public int getGateNumber() {
        return gateNumber;
    }

    public void setGateNumber(int gateNumber) {
        this.gateNumber = gateNumber;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public GateStatus getGateStatus() {
        return gateStatus;
    }

    public void setGateStatus(GateStatus gateStatus) {
        this.gateStatus = gateStatus;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public GateType getGateType() {
        return gateType;
    }

    public void setGateType(GateType gateType) {
        this.gateType = gateType;
    }

    public boolean isOperational() {
        return gateStatus == GateStatus.OPERATIONAL;
    }

    public void openGate() {
        if (isOperational()) {
            System.out.println("Gate " + gateNumber + " is now open.");
        } else {
            System.out.println("Gate " + gateNumber + " cannot be opened as it is not operational.");
        }
    }

    public void closeGate() {
        if (isOperational()) {
            System.out.println("Gate " + gateNumber + " is now closed.");
        } else {
            System.out.println("Gate " + gateNumber + " cannot be closed as it is not operational.");
        }
    }

    public void toggleGate() {
        if (isOperational()) {
            System.out.println("Toggling gate " + gateNumber + " status.");
        } else {
            System.out.println("Gate " + gateNumber + " cannot be toggled as it is not operational.");
        }
    }

    public void printDetails() {
        System.out.println("Gate Number: " + gateNumber);
        System.out.println("Status: " + status);
        System.out.println("Gate Status: " + gateStatus);
        System.out.println("Operator: " + operator);
        System.out.println("Gate Type: " + gateType);
    }

    public void validate() {
        if (gateNumber <= 0) {
            throw new IllegalArgumentException("Invalid gate number");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status is required");
        }
        if (gateStatus == null) {
            throw new IllegalArgumentException("Gate status is required");
        }
        if (operator == null) {
            throw new IllegalArgumentException("Operator is required");
        }
        if (gateType == null) {
            throw new IllegalArgumentException("Gate type is required");
        }
    }

    public void updateGateStatus(GateStatus newStatus) {
        setGateStatus(newStatus);
        System.out.println("Gate " + gateNumber + " status updated to " + newStatus);
    }
}
