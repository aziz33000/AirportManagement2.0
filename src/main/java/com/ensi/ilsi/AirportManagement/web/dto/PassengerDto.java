package com.ensi.ilsi.AirportManagement.web.dto;

import com.ensi.ilsi.AirportManagement.domain.Employee;
import com.ensi.ilsi.AirportManagement.domain.Flight;
import com.ensi.ilsi.AirportManagement.domain.Ticket;

import java.util.Set;

public class PassengerDto {

    private Long id;
    private String namee;
    private String sex;
    private long age;
    private String adress;
    private Set<Employee> employees ;
    private Flight flight;
    private Set<Ticket> booking;

    public PassengerDto() {
        // JACKSON
    }

    public PassengerDto( Long id,String namee, String sex, long age, String adress, Set<Employee> employees, Flight flight, Set<Ticket> booking) {
        this.id = id;
        this.namee = namee;
        this.sex = sex;
        this.age = age;
        this.adress = adress;
        this.employees = employees;
        this.flight = flight;
        this.booking = booking;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNamee() {
        return namee;
    }

    public void setNamee(String namee) {
        this.namee = namee;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public long getAge() {
        return age;
    }

    public void setAge(long age) {
        this.age = age;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public Set<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(Set<Employee> employees) {
        this.employees = employees;
    }

    public Flight getFlight() {
        return flight;
    }

    public void setFlight(Flight flight) {
        this.flight = flight;
    }

    public Set<Ticket> getBooking() {
        return booking;
    }

    public void setBooking(Set<Ticket> booking) {
        this.booking = booking;
    }
}
