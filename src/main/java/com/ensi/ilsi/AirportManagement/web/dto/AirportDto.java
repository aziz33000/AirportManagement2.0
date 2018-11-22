package com.ensi.ilsi.AirportManagement.web.dto;

import com.ensi.ilsi.AirportManagement.domain.Airline;
import com.ensi.ilsi.AirportManagement.domain.City;
import com.ensi.ilsi.AirportManagement.domain.Employee;
import com.ensi.ilsi.AirportManagement.domain.enumeration.AirportStatus;

import java.util.Set;

public class AirportDto {
    private Long id;
    private String apName;
    private String country;
    private AirportStatus status;
    private Set<Employee> employees;
    private City city;
    private Set<Airline> airlines ;


    public AirportDto() {
        // JACKSON
    }

    public AirportDto(Long id, String apName, String country, AirportStatus status, Set<Employee> employees, City city, Set<Airline> airlines) {
        this.id = id;
        this.apName = apName;
        this.country = country;
        this.status = status;
        this.employees = employees;
        this.city = city;
        this.airlines = airlines;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Set<Airline> getAirlines() {
        return airlines;
    }

    public void setAirlines(Set<Airline> airlines) {
        this.airlines = airlines;
    }
}
