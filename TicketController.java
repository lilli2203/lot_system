package com.parking.Controllers;

import com.parking.Dto.generateTicketRequestDto;
import com.parking.Dto.generateTicketResponseDto;
import com.parking.Models.Ticket;
import com.parking.Services.TicketService;
import java.time.LocalDateTime;

public class TicketController {

    private TicketService ticketService;

    public TicketController(TicketService ticketService) {
        this.ticketService = ticketService;
    }

    public generateTicketResponseDto generateTicket(generateTicketRequestDto request) {
        if (request == null || request.getVehicleId() == null || request.getParkingLotId() == null) {
            throw new IllegalArgumentException("Invalid request data");
        }

        Ticket ticket = new Ticket();
        ticket.setVehicleId(request.getVehicleId());
        ticket.setParkingLotId(request.getParkingLotId());
        ticket.setEntryTime(LocalDateTime.now());

        Ticket savedTicket = ticketService.saveTicket(ticket);

        generateTicketResponseDto response = new generateTicketResponseDto();
        response.setTicketId(savedTicket.getTicketId());
        response.setVehicleId(savedTicket.getVehicleId());
        response.setParkingLotId(savedTicket.getParkingLotId());
        response.setEntryTime(savedTicket.getEntryTime());

        return response;
    }

    public generateTicketResponseDto getTicketDetails(String ticketId) {
        Ticket ticket = ticketService.getTicketById(ticketId);

        if (ticket == null) {
            throw new IllegalArgumentException("Ticket not found");
        }

        generateTicketResponseDto response = new generateTicketResponseDto();
        response.setTicketId(ticket.getTicketId());
        response.setVehicleId(ticket.getVehicleId());
        response.setParkingLotId(ticket.getParkingLotId());
        response.setEntryTime(ticket.getEntryTime());

        return response;
    }

    public generateTicketResponseDto updateTicket(String ticketId, generateTicketRequestDto request) {
        Ticket ticket = ticketService.getTicketById(ticketId);

        if (ticket == null) {
            throw new IllegalArgumentException("Ticket not found");
        }

        ticket.setParkingLotId(request.getParkingLotId());
        ticket.setEntryTime(LocalDateTime.now()); // Assuming we update the entry time as well

        Ticket updatedTicket = ticketService.saveTicket(ticket);

        generateTicketResponseDto response = new generateTicketResponseDto();
        response.setTicketId(updatedTicket.getTicketId());
        response.setVehicleId(updatedTicket.getVehicleId());
        response.setParkingLotId(updatedTicket.getParkingLotId());
        response.setEntryTime(updatedTicket.getEntryTime());

        return response;
    }

    public void deleteTicket(String ticketId) {
        ticketService.deleteTicket(ticketId);
    }
}
