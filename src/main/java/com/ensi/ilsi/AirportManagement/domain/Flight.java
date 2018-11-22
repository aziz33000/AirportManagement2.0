package com.ensi.ilsi.AirportManagement.domain;


import com.ensi.ilsi.AirportManagement.domain.enumeration.FlightStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "flight")
public class Flight extends  AbstractEntity {



    @Column(name = "flightCode")
    private String flightCode;

    @Column(name = "source")
    private String source;

    @Column(name = "destination")
    private  String destination;

    @Enumerated(EnumType.STRING)
    @Column(name = "status")
    private FlightStatus flightStatus;

    @OneToMany(mappedBy = "flight")
    @JsonIgnore
    private Set<Passenger> passengers ;

    @ManyToOne
    private Airline airline ;





    public Flight() {
        // JPA
    }

    public Flight(String flightCode, String source, String destination, FlightStatus flightStatus, Set<Passenger> passengers, Airline airline) {
        this.flightCode = flightCode;
        this.source = source;
        this.destination = destination;
        this.flightStatus = flightStatus;
        this.passengers = passengers;
        this.airline = airline;
    }


    public String getFlightCode() {
        return flightCode;
    }

    public void setFlightCode(String flightCode) {
        this.flightCode = flightCode;
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

    public FlightStatus getFlightStatus() {
        return flightStatus;
    }

    public void setFlightStatus(FlightStatus flightStatus) {
        this.flightStatus = flightStatus;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }

    public Airline getAirline() {
        return airline;
    }

    public void setAirline(Airline airline) {
        this.airline = airline;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Flight flight = (Flight) o;
        return Objects.equals(flightCode, flight.flightCode) &&
                Objects.equals(source, flight.source) &&
                Objects.equals(destination, flight.destination) &&
                flightStatus == flight.flightStatus &&
                Objects.equals(passengers, flight.passengers) &&
                Objects.equals(airline, flight.airline);
    }

    @Override
    public int hashCode() {

        return Objects.hash(flightCode, source, destination, flightStatus, passengers, airline);
    }

    @Override
    public String toString() {
        return "Flight{" +
                "flightCode='" + flightCode + '\'' +
                ", source='" + source + '\'' +
                ", destination='" + destination + '\'' +
                ", flightStatus=" + flightStatus +
                ", passengers=" + passengers +
                ", airline=" + airline +
                '}';
    }
}
