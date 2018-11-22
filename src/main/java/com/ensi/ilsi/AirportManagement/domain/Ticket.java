package com.ensi.ilsi.AirportManagement.domain;


import com.ensi.ilsi.AirportManagement.domain.enumeration.TicketClass;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "ticket")
public class Ticket extends AbstractEntity {




    @Column(name="ticketNumber")
    private long ticketNumber;

    @Column(name="price")
    private long price;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private String destination;

    @Enumerated(EnumType.STRING)
    @Column(name = "ticketClass")
    private TicketClass ticketClass;

    @ManyToOne
    private Passenger passenger;






    public Ticket() {
        // JPA
    }

    public Ticket(long ticketNumber, long price, String source, String destination, TicketClass ticketClass, Passenger passenger) {
        this.ticketNumber = ticketNumber;
        this.price = price;
        this.source = source;
        this.destination = destination;
        this.ticketClass = ticketClass;
        this.passenger = passenger;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return ticketNumber == ticket.ticketNumber &&
                price == ticket.price &&
                Objects.equals(source, ticket.source) &&
                Objects.equals(destination, ticket.destination) &&
                ticketClass == ticket.ticketClass &&
                Objects.equals(passenger, ticket.passenger);
    }

    @Override
    public int hashCode() {

        return Objects.hash(ticketNumber, price, source, destination, ticketClass, passenger);
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketNumber=" + ticketNumber +
                ", price=" + price +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", ticketClass=" + ticketClass +
                ", passenger=" + passenger +
                '}';
    }
}
