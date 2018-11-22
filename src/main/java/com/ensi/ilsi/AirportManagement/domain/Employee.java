package com.ensi.ilsi.AirportManagement.domain;


import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "employee")
public class Employee extends AbstractEntity {


    @Column(name = "name")
    private String name;

    @Column(name = "sex")
    private String sex;

    @Column(name = "adress")
    private String adress;

    @Column(name = "age")
    private String age;

    @Column(name = "salary")
    private String salary;

    @Column(name = "jobType")
    private String jobType;

    @ManyToOne
    private Airport airport;

    @ManyToMany(mappedBy = "employees")
    private Set<Passenger> passengers  = new HashSet<>() ;





    public Employee() {
        // JPA
    }

    public Employee(String name, String sex, String adress, String age, String salary, String jobType, Airport airport, Set<Passenger> passengers) {
        this.name = name;
        this.sex = sex;
        this.adress = adress;
        this.age = age;
        this.salary = salary;
        this.jobType = jobType;
        this.airport = airport;
        this.passengers = passengers;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return Objects.equals(name, employee.name) &&
                Objects.equals(sex, employee.sex) &&
                Objects.equals(adress, employee.adress) &&
                Objects.equals(age, employee.age) &&
                Objects.equals(salary, employee.salary) &&
                Objects.equals(jobType, employee.jobType) &&
                Objects.equals(airport, employee.airport) &&
                Objects.equals(passengers, employee.passengers);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, sex, adress, age, salary, jobType, airport, passengers);
    }

    @Override
    public String toString() {
        return "Employee{" +
                "name='" + name + '\'' +
                ", sex='" + sex + '\'' +
                ", adress='" + adress + '\'' +
                ", age='" + age + '\'' +
                ", salary='" + salary + '\'' +
                ", jobType='" + jobType + '\'' +
                ", airport=" + airport +
                ", passengers=" + passengers +
                '}';
    }
}
