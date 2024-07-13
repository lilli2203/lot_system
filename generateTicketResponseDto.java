package com.parking.Dto;

import com.parking.Modules.Ticket;
import java.time.LocalDateTime;

public class generateTicketResponseDto {

    private Ticket ticket;
    private ResponseStatus responseStatus;
    private String message;
    private LocalDateTime timestamp;
    private String issuedBy;

    public generateTicketResponseDto(Ticket ticket, ResponseStatus responseStatus, String message, LocalDateTime timestamp, String issuedBy) {
        this.ticket = ticket;
        this.responseStatus = responseStatus;
        this.message = message;
        this.timestamp = timestamp;
        this.issuedBy = issuedBy;
    }

    public generateTicketResponseDto() {
        this.timestamp = LocalDateTime.now(); 
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public ResponseStatus getResponseStatus() {
        return responseStatus;
    }

    public void setResponseStatus(ResponseStatus responseStatus) {
        this.responseStatus = responseStatus;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getIssuedBy() {
        return issuedBy;
    }

    public void setIssuedBy(String issuedBy) {
        this.issuedBy = issuedBy;
    }

    public void displayResponseDetails() {
        System.out.println("Response Status: " + responseStatus);
        System.out.println("Message: " + message);
        System.out.println("Timestamp: " + timestamp);
        System.out.println("Issued By: " + issuedBy);
        if (ticket != null) {
            System.out.println("Ticket ID: " + ticket.getId());
            System.out.println("Ticket Issue Time: " + ticket.getIssueTime());
        } else {
            System.out.println("No Ticket Information Available");
        }
    }

    public void updateResponse(Ticket ticket, ResponseStatus responseStatus, String message, String issuedBy) {
        this.ticket = ticket;
        this.responseStatus = responseStatus;
        this.message = message;
        this.issuedBy = issuedBy;
        this.timestamp = LocalDateTime.now(); 
    }

    @Override
    public String toString() {
        return "generateTicketResponseDto{" +
                "ticket=" + ticket +
                ", responseStatus=" + responseStatus +
                ", message='" + message + '\'' +
                ", timestamp=" + timestamp +
                ", issuedBy='" + issuedBy + '\'' +
                '}';
    }
}
