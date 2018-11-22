package com.ensi.ilsi.AirportManagement.domain;



import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "city")
public class City extends  AbstractEntity {




    @Column (name = "cityName")
    private  String cityName;

    @Column (name  = "country")
    private String country;

    @OneToOne(mappedBy = "city")
    @JsonIgnore
    private Airport airport;






    public City() {
        // JPA
    }

    public City(String cityName, String country, Airport airport) {
        this.cityName = cityName;
        this.country = country;
        this.airport = airport;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Airport getAirport() {
        return airport;
    }

    public void setAirport(Airport airport) {
        this.airport = airport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        City city = (City) o;
        return Objects.equals(cityName, city.cityName) &&
                Objects.equals(country, city.country) &&
                Objects.equals(airport, city.airport);
    }

    @Override
    public int hashCode() {

        return Objects.hash(cityName, country, airport);
    }

    @Override
    public String toString() {
        return "City{" +
                "cityName='" + cityName + '\'' +
                ", country='" + country + '\'' +
                ", airport=" + airport +
                '}';
    }
}
