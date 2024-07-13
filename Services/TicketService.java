package com.parking.Services;

import com.parking.Exceptions.InvalidException;
import com.parking.Modules.Gates;
import com.parking.Modules.Ticket;
import com.parking.Modules.Vehicle;
import com.parking.Modules.VehicleType;
import com.parking.Repositories.GateRepository;
import com.parking.Repositories.VehicleRepository;

import java.util.Date;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;

public class TicketService {
    private GateRepository gateRepository;
    private VehicleRepository vehicleRepository;
    private static final Logger logger = Logger.getLogger(TicketService.class.getName());

    public TicketService(GateRepository gateRepository, VehicleRepository vehicleRepository) {
        this.gateRepository = gateRepository;
        this.vehicleRepository = vehicleRepository;
    }

    public Ticket generateTicket(Long gateId, String vehicleNumber, VehicleType vehicleType, String ownerName) throws InvalidException {
        validateVehicleNumber(vehicleNumber);

        Ticket ticket = new Ticket();
        ticket.setEntryTime(new Date());

        Optional<Gates> optionalGate = gateRepository.findById(gateId);
        if (optionalGate.isEmpty()) {
            logger.log(Level.SEVERE, "Invalid Gate Id: " + gateId);
            throw new InvalidException("Invalid Gate Id");
        }

        Gates gate = optionalGate.get();
        ticket.setGenratedAt(gate);
        ticket.setGenratedBy(gate.getOperator());

        Optional<Vehicle> optionalVehicle = vehicleRepository.findByNumber(vehicleNumber);
        Vehicle vehicle;
        if (optionalVehicle.isPresent()) {
            vehicle = optionalVehicle.get();
        } else {
            vehicle = new Vehicle();
            vehicle.setOwnerName(ownerName);
            vehicle.setVehiclenumber(vehicleNumber);
            vehicle.setVehicleType(vehicleType);
            vehicleRepository.save(vehicle);
        }
        ticket.setVehicle(vehicle);
        logger.log(Level.INFO, "Ticket generated for vehicle: " + vehicleNumber + " at gate: " + gateId);

        return ticket;
    }

    private void validateVehicleNumber(String vehicleNumber) throws InvalidException {
        if (vehicleNumber == null || vehicleNumber.isEmpty() || !vehicleNumber.matches("^[A-Z0-9-]+$")) {
            logger.log(Level.SEVERE, "Invalid vehicle number: " + vehicleNumber);
            throw new InvalidException("Invalid vehicle number");
        }
    }

    public void updateTicket(Long ticketId, String newVehicleNumber, VehicleType newVehicleType, String newOwnerName) throws InvalidException {
        validateVehicleNumber(newVehicleNumber);

        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isEmpty()) {
            logger.log(Level.SEVERE, "Invalid Ticket Id: " + ticketId);
            throw new InvalidException("Invalid Ticket Id");
        }

        Ticket ticket = optionalTicket.get();
        Vehicle vehicle = ticket.getVehicle();
        vehicle.setVehiclenumber(newVehicleNumber);
        vehicle.setVehicleType(newVehicleType);
        vehicle.setOwnerName(newOwnerName);

        vehicleRepository.save(vehicle);
        ticketRepository.save(ticket);

        logger.log(Level.INFO, "Ticket updated for vehicle: " + newVehicleNumber + " with ticket ID: " + ticketId);
    }

    public void cancelTicket(Long ticketId) throws InvalidException {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isEmpty()) {
            logger.log(Level.SEVERE, "Invalid Ticket Id: " + ticketId);
            throw new InvalidException("Invalid Ticket Id");
        }

        ticketRepository.deleteById(ticketId);
        logger.log(Level.INFO, "Ticket canceled with ID: " + ticketId);
    }

    public Ticket getTicket(Long ticketId) throws InvalidException {
        Optional<Ticket> optionalTicket = ticketRepository.findById(ticketId);
        if (optionalTicket.isEmpty()) {
            logger.log(Level.SEVERE, "Invalid Ticket Id: " + ticketId);
            throw new InvalidException("Invalid Ticket Id");
        }

        Ticket ticket = optionalTicket.get();
        logger.log(Level.INFO, "Ticket retrieved with ID: " + ticketId);

        return ticket;
    }
}
