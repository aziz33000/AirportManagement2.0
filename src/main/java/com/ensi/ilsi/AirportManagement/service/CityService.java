package com.ensi.ilsi.AirportManagement.service;

import com.ensi.ilsi.AirportManagement.domain.City;
import com.ensi.ilsi.AirportManagement.repository.CityRepository;
import com.ensi.ilsi.AirportManagement.web.dto.CityDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class CityService {

    private final Logger log = LoggerFactory.getLogger(CityService.class);

    private final CityRepository cityRepository;

    public CityService(CityRepository cityRepository) {
        this.cityRepository = cityRepository;
    }

    public List<CityDto> findAll(){
        log.debug("Request to get all Cities");
        return this.cityRepository.findAll()
                .stream()
                .map(CityService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public CityDto findById(Long id) {
        log.debug("Request to get City : {}", id);
        return this.cityRepository.findById(id).map(CityService::mapToDto).orElse(null);
    }

    public CityDto create(CityDto cityDto) {
        log.debug("Request to create City : {}", cityDto);

        return mapToDto(this.cityRepository.save(
                new City(
                        cityDto.getCityName(),
                        cityDto.getCountry(),
                        cityDto.getAirport()
                )));
    }

    public void delete(Long id) {
        log.debug("Request to delete City : {}", id);
        this.cityRepository.deleteById(id);
    }

    public static CityDto mapToDto(City city) {
        if (city != null) {
            return new CityDto(
                    city.getId(),
                    city.getCityName(),
                    city.getCountry(),
                    city.getAirport()
            );
        }
        return null;
    }
}
