package com.parking.Modules;

import java.sql.Time;
import java.util.List;

public class Bill extends BaseModel {

    private int TictetNumber; 
    private Time exitTime;
    private double amount;
    private Ticket ticket;
    private Gates gate;
    private Operator operator;
    private BillStatus status;
    private List<Payment> payments;
    private Status status1; 

    public int getTictetNumber() {
        return TictetNumber;
    }

    public void setTictetNumber(int tictetNumber) {
        TictetNumber = tictetNumber;
    }

    public Time getExitTime() {
        return exitTime;
    }

    public void setExitTime(Time exitTime) {
        this.exitTime = exitTime;
    }

    public double getAmount() {
        return amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Gates getGate() {
        return gate;
    }

    public void setGate(Gates gate) {
        this.gate = gate;
    }

    public Operator getOperator() {
        return operator;
    }

    public void setOperator(Operator operator) {
        this.operator = operator;
    }

    public BillStatus getStatus() {
        return status;
    }

    public void setStatus(BillStatus status) {
        this.status = status;
    }

    public List<Payment> getPayments() {
        return payments;
    }

    public void setPayments(List<Payment> payments) {
        this.payments = payments;
    }

    public double calculateTotalPayments() {
        return payments.stream().mapToDouble(Payment::getAmount).sum();
    }

    public boolean isFullyPaid() {
        return calculateTotalPayments() >= amount;
    }

    public String generateSummary() {
        return "Bill ID: " + id +
               "\nTicket Number: " + TictetNumber +
               "\nExit Time: " + exitTime +
               "\nAmount: " + amount +
               "\nStatus: " + status +
               "\nPayments: " + payments.size();
    }

    public void validate() {
        if (TictetNumber <= 0) {
            throw new IllegalArgumentException("Invalid ticket number");
        }
        if (exitTime == null) {
            throw new IllegalArgumentException("Exit time is required");
        }
        if (amount <= 0) {
            throw new IllegalArgumentException("Amount must be greater than zero");
        }
        if (ticket == null) {
            throw new IllegalArgumentException("Ticket is required");
        }
        if (gate == null) {
            throw new IllegalArgumentException("Gate is required");
        }
        if (operator == null) {
            throw new IllegalArgumentException("Operator is required");
        }
        if (status == null) {
            throw new IllegalArgumentException("Status is required");
        }
    }
}
