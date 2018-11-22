package com.ensi.ilsi.AirportManagement.web.dto;

import com.ensi.ilsi.AirportManagement.domain.Passenger;
import com.ensi.ilsi.AirportManagement.domain.enumeration.TicketClass;

public class TicketDto {

    private Long id;
    private long ticketNumber;
    private long price;
    private String source;
    private String destination;
    private TicketClass ticketClass;
    private Passenger passenger;

    public TicketDto() {
        //JACKSON
    }

    public TicketDto(Long id,long ticketNumber, long price, String source, String destination, TicketClass ticketClass, Passenger passenger) {
        this.id = id;
        this.ticketNumber = ticketNumber;
        this.price = price;
        this.source = source;
        this.destination = destination;
        this.ticketClass = ticketClass;
        this.passenger = passenger;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public long getTicketNumber() {
        return ticketNumber;
    }

    public void setTicketNumber(long ticketNumber) {
        this.ticketNumber = ticketNumber;
    }

    public long getPrice() {
        return price;
    }

    public void setPrice(long price) {
        this.price = price;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public TicketClass getTicketClass() {
        return ticketClass;
    }

    public void setTicketClass(TicketClass ticketClass) {
        this.ticketClass = ticketClass;
    }

    public Passenger getPassenger() {
        return passenger;
    }

    public void setPassenger(Passenger passenger) {
        this.passenger = passenger;
    }
}
