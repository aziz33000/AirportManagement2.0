package com.ensi.ilsi.AirportManagement.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "passenger")
public class Passenger extends  AbstractEntity {



    @Column(name = "name")
    private String namee;

    @Column(name = "sex")
    private String sex;

    @Column(name = "age")
    private long age;

    @Column(name = "adress")
    private String adress;

    @ManyToMany
    private Set<Employee> employees  = new HashSet<>() ;

    @ManyToOne
    private Flight flight;

    @OneToMany(mappedBy = "passenger")
    private Set<Ticket> booking;







    public Passenger() {
        // JPA
    }

    public Passenger(String namee, String sex, long age, String adress, Set<Employee> employees, Flight flight, Set<Ticket> booking) {
        this.namee = namee;
        this.sex = sex;
        this.age = age;
        this.adress = adress;
        this.employees = employees;
        this.flight = flight;
        this.booking = booking;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Passenger passenger = (Passenger) o;
        return age == passenger.age &&
                Objects.equals(namee, passenger.namee) &&
                Objects.equals(sex, passenger.sex) &&
                Objects.equals(adress, passenger.adress) &&
                Objects.equals(employees, passenger.employees) &&
                Objects.equals(flight, passenger.flight) &&
                Objects.equals(booking, passenger.booking);
    }

    @Override
    public int hashCode() {

        return Objects.hash(namee, sex, age, adress, employees, flight, booking);
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "namee='" + namee + '\'' +
                ", sex='" + sex + '\'' +
                ", age=" + age +
                ", adress='" + adress + '\'' +
                ", employees=" + employees +
                ", flight=" + flight +
                ", booking=" + booking +
                '}';
    }
}
