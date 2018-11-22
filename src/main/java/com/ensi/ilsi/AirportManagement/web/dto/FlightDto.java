package com.ensi.ilsi.AirportManagement.web.dto;

import com.ensi.ilsi.AirportManagement.domain.Airline;
import com.ensi.ilsi.AirportManagement.domain.Passenger;
import com.ensi.ilsi.AirportManagement.domain.enumeration.FlightStatus;

import java.util.Set;

public class FlightDto {

    private Long id;
    private String flightCode;
    private String source;
    private  String destination;
    private FlightStatus flightStatus;
    private Set<Passenger> passengers ;
    private Airline airline ;

    public FlightDto() {
        // JACKSON
    }

    public FlightDto(Long id,String flightCode, String source, String destination, FlightStatus flightStatus, Set<Passenger> passengers, Airline airline) {
        this.id = id;
        this.flightCode = flightCode;
        this.source = source;
        this.destination = destination;
        this.flightStatus = flightStatus;
        this.passengers = passengers;
        this.airline = airline;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
