package com.ensi.ilsi.AirportManagement.service;

import com.ensi.ilsi.AirportManagement.domain.Flight;
import com.ensi.ilsi.AirportManagement.repository.FlightRepository;
import com.ensi.ilsi.AirportManagement.web.dto.FlightDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class FlightService {

    private final Logger log = LoggerFactory.getLogger(FlightService.class);

    private final FlightRepository flightRepository;

    public FlightService(FlightRepository flightRepository) {
        this.flightRepository = flightRepository;
    }

    public List<FlightDto> findAll(){
        log.debug("Request to get all Flights");
        return this.flightRepository.findAll()
                .stream()
                .map(FlightService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public FlightDto findById(Long id) {
        log.debug("Request to get Flight : {}", id);
        return this.flightRepository.findById(id).map(FlightService::mapToDto).orElse(null);
    }

    public FlightDto create(FlightDto flightDto) {
        log.debug("Request to create Flight : {}", flightDto);

        return mapToDto(this.flightRepository.save(
                new Flight(
                        flightDto.getFlightCode(),
                        flightDto.getSource(),
                        flightDto.getDestination(),
                        flightDto.getFlightStatus(),
                        flightDto.getPassengers(),
                        flightDto.getAirline()

                )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Flight : {}", id);
        this.flightRepository.deleteById(id);
    }

    public static FlightDto mapToDto(Flight flight) {
        if (flight != null) {
            return new FlightDto(
                    flight.getId(),
                    flight.getFlightCode(),
                    flight.getSource(),
                    flight.getDestination(),
                    flight.getFlightStatus(),
                    flight.getPassengers(),
                    flight.getAirline()
            );
        }
        return null;
    }
}
