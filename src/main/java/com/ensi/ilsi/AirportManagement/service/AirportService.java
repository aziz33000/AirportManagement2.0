package com.ensi.ilsi.AirportManagement.service;

import com.ensi.ilsi.AirportManagement.domain.Airline;
import com.ensi.ilsi.AirportManagement.domain.Airport;
import com.ensi.ilsi.AirportManagement.repository.AirportRepository;
import com.ensi.ilsi.AirportManagement.web.dto.AirportDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirportService {
    private final Logger log = LoggerFactory.getLogger(AirportService.class);

    private final AirportRepository airportRepository;

    public AirportService(AirportRepository airportRepository) {
        this.airportRepository = airportRepository;
    }

    public List<AirportDto> findAll(){
        log.debug("Request to get all Airports");
        return this.airportRepository.findAll()
                .stream()
                .map(AirportService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AirportDto findById(Long id) {
        log.debug("Request to get Airport : {}", id);
        return this.airportRepository.findById(id).map(AirportService::mapToDto).orElse(null);
    }

    public AirportDto create(AirportDto airportDto) {
        log.debug("Request to create Airport : {}", airportDto);

        return mapToDto(this.airportRepository.save(
                new Airport(
                        airportDto.getApName(),
                        airportDto.getCountry(),
                        airportDto.getStatus(),
                        airportDto.getEmployees(),
                        airportDto.getCity(),
                        (Set<Airline>) airportDto.getAirlines()

                )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Airport : {}", id);
        this.airportRepository.deleteById(id);
    }

    public static AirportDto mapToDto(Airport airport) {
        if (airport != null) {
            return new AirportDto(
                    airport.getId(),
                    airport.getApName(),
                    airport.getCountry(),
                    airport.getStatus(),
                    airport.getEmployees(),
                    airport.getCity(),
                    airport.getAirlines()
            );
        }
        return null;
    }
}
