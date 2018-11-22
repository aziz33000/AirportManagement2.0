package com.ensi.ilsi.AirportManagement.web.dto;

import com.ensi.ilsi.AirportManagement.domain.Airport;
import com.ensi.ilsi.AirportManagement.domain.Flight;

import java.util.HashSet;
import java.util.Set;

public class AirlineDto {

    private Long id;
    private String airlineName;
    private int threeDigitCode;
    private Set<Airport> airports;
    private Set<Flight> flights;

    public AirlineDto() {
        //JACKSON
    }

    public AirlineDto(Long id,String airlineName, int threeDigitCode, Set<Airport> airports, Set<Flight> flights) {
        this.id = id;
        this.airlineName = airlineName;
        this.threeDigitCode = threeDigitCode;
        this.airports = airports;
        this.flights = flights;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getAirlineName() {
        return airlineName;
    }

    public void setAirlineName(String airlineName) {
        this.airlineName = airlineName;
    }

    public int getThreeDigitCode() {
        return threeDigitCode;
    }

    public void setThreeDigitCode(int threeDigitCode) {
        this.threeDigitCode = threeDigitCode;
    }

    public Set<Airport> getAirports() {
        return airports;
    }

    public void setAirports(Set<Airport> airports) {
        this.airports = airports;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
    }
}
