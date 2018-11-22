package com.ensi.ilsi.AirportManagement.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "airline")
public class Airline extends AbstractEntity {


    @Column(name = "airlineName")
    private String airlineName;

    @Column(name = "threeDigitCode")
    private int threeDigitCode;

    @ManyToMany(mappedBy = "airlines")
    private Set<Airport> airports = new HashSet<>();

    @OneToMany(mappedBy = "airline")
    @JsonIgnore
    private Set<Flight> flights;






    public Airline() {
        // jps
    }

    public Airline(String airlineName, int threeDigitCode, Set<Airport> airports, Set<Flight> flights) {
        this.airlineName = airlineName;
        this.threeDigitCode = threeDigitCode;
        this.airports = airports;
        this.flights = flights;
    }

    public Set<Flight> getFlights() {
        return flights;
    }

    public void setFlights(Set<Flight> flights) {
        this.flights = flights;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Airline airline = (Airline) o;
        return threeDigitCode == airline.threeDigitCode &&
                Objects.equals(airlineName, airline.airlineName) &&
                Objects.equals(airports, airline.airports) &&
                Objects.equals(flights, airline.flights);
    }

    @Override
    public int hashCode() {

        return Objects.hash(airlineName, threeDigitCode, airports, flights);
    }

    @Override
    public String toString() {
        return "Airline{" +
                "airlineName='" + airlineName + '\'' +
                ", threeDigitCode=" + threeDigitCode +
                ", airports=" + airports +
                ", flights=" + flights +
                '}';
    }
}
