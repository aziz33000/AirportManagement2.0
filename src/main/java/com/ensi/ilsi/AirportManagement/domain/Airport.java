package com.ensi.ilsi.AirportManagement.domain;

import com.ensi.ilsi.AirportManagement.domain.enumeration.AirportStatus;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "airport")
public class Airport extends AbstractEntity {



    @NotNull
    @Column(name = "apName", nullable = false)
    private String apName;

    @NotNull
    @Column(name = "country", nullable = false)
    private String country;

    @NotNull
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private AirportStatus status;

    @OneToMany(mappedBy = "airport")
    @JsonIgnore
    private Set<Employee> employees;

    @OneToOne
    @JoinColumn(unique = true)
    private City city;

    @ManyToMany
    private Set<Airline> airlines = new HashSet<>() ;








    public Airport() {
        // JPA
    }

    public Airport(@NotNull String apName, @NotNull String country, @NotNull AirportStatus status, Set<Employee> employees, City city, Set<Airline> airlines) {
        this.apName = apName;
        this.country = country;
        this.status = status;
        this.employees = employees;
        this.city = city;
        this.airlines = airlines;
    }

    public String getApName() {
        return apName;
    }

    public void setApName(String apName) {
        this.apName = apName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public AirportStatus getStatus() {
        return status;
    }

    public void setStatus(AirportStatus status) {
        this.status = status;
    }

    public Set<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(Set<Airline> airlines) {
        this.airlines = airlines;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public City getCity() {
        return city;
    }

    public void setCity(City city) {
        this.city = city;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Airport)) return false;
        Airport airport = (Airport) o;
        return Objects.equals(apName, airport.apName) &&
                Objects.equals(country, airport.country) &&
                status == airport.status &&
                Objects.equals(employees, airport.employees) &&
                Objects.equals(city, airport.city) &&
                Objects.equals(airlines, airport.airlines);
    }

    @Override
    public int hashCode() {

        return Objects.hash(apName, country, status, employees, city, airlines);
    }

    @Override
    public String toString() {
        return "Airport{" +
                "apName='" + apName + '\'' +
                ", country='" + country + '\'' +
                ", status=" + status +
                ", employees=" + employees +
                ", city=" + city +
                ", airlines=" + airlines +
                '}';
    }
}
