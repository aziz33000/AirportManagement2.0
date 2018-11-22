package com.ensi.ilsi.AirportManagement.web.dto;

import com.ensi.ilsi.AirportManagement.domain.Airport;

public class CityDto {


    private Long id;
    private  String cityName;
    private String country;
    private Airport airport;

    public CityDto() {
        // JACKSON
    }

    public CityDto(Long id,String cityName, String country, Airport airport) {
        this.id = id;
        this.cityName = cityName;
        this.country = country;
        this.airport = airport;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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
}
