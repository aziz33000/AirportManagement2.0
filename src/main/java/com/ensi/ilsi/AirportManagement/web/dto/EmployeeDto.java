package com.ensi.ilsi.AirportManagement.web.dto;

import com.ensi.ilsi.AirportManagement.domain.Airport;
import com.ensi.ilsi.AirportManagement.domain.Passenger;

import java.util.Set;

public class EmployeeDto {

    private Long id;
    private String name;
    private String sex;
    private String adress;
    private String age;
    private String salary;
    private String jobType;
    private Airport airport;
    private Set<Passenger> passengers ;

    public EmployeeDto() {
        // JACKSON
    }

    public EmployeeDto(Long id,String name, String sex, String adress, String age, String salary, String jobType, Airport airport, Set<Passenger> passengers) {
        this.id = id;
        this.name = name;
        this.sex = sex;
        this.adress = adress;
        this.age = age;
        this.salary = salary;
        this.jobType = jobType;
        this.airport = airport;
        this.passengers = passengers;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getAdress() {
        return adress;
    }

    public void setAdress(String adress) {
        this.adress = adress;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }

    public String getJobType() {
        return jobType;
    }

    public void setJobType(String jobType) {
        this.jobType = jobType;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    public Set<Passenger> getPassengers() {
        return passengers;
    }

    public void setPassengers(Set<Passenger> passengers) {
        this.passengers = passengers;
    }
}
