package com.ensi.ilsi.AirportManagement.service;

import com.ensi.ilsi.AirportManagement.domain.Airline;
import com.ensi.ilsi.AirportManagement.repository.AirlineRepository;
import com.ensi.ilsi.AirportManagement.web.dto.AirlineDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class AirlineService {

    private final Logger log = LoggerFactory.getLogger(AirlineService.class);

    private final AirlineRepository airlineRepository;

    public AirlineService(AirlineRepository airlineRepository) {
        this.airlineRepository = airlineRepository;
    }

    public List<AirlineDto> findAll(){
        log.debug("Request to get all Airlines");
        return this.airlineRepository.findAll()
                .stream()
                .map(AirlineService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public AirlineDto findById(Long id) {
        log.debug("Request to get Airline : {}", id);
        return this.airlineRepository.findById(id).map(AirlineService::mapToDto).orElse(null);
    }

    public AirlineDto create(AirlineDto airlineDto) {
        log.debug("Request to create Airline : {}", airlineDto);

        return mapToDto(this.airlineRepository.save(
                new Airline(
                        airlineDto.getAirlineName(),
                        airlineDto.getThreeDigitCode(),
                        airlineDto.getAirports(),
                        airlineDto.getFlights()
                )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Airline : {}", id);
        this.airlineRepository.deleteById(id);
    }

    public static AirlineDto mapToDto(Airline airline) {
        if (airline != null) {
            return new AirlineDto(
                    airline.getId(),
                    airline.getAirlineName(),
                    airline.getThreeDigitCode(),
                    airline.getAirports(),
                    airline.getFlights()
            );
        }
        return null;
    }
}
