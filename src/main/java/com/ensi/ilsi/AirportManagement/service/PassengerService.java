package com.ensi.ilsi.AirportManagement.service;

import com.ensi.ilsi.AirportManagement.domain.Passenger;
import com.ensi.ilsi.AirportManagement.repository.PassengerRepository;
import com.ensi.ilsi.AirportManagement.web.dto.PassengerDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class PassengerService {

    private final Logger log = LoggerFactory.getLogger(PassengerService.class);

    private final PassengerRepository passengerRepository;

    public PassengerService(PassengerRepository passengerRepository) {
        this.passengerRepository = passengerRepository;
    }

    public List<PassengerDto> findAll(){
        log.debug("Request to get all Passengers");
        return this.passengerRepository.findAll()
                .stream()
                .map(PassengerService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public PassengerDto findById(Long id) {
        log.debug("Request to get Passenger : {}", id);
        return this.passengerRepository.findById(id).map(PassengerService::mapToDto).orElse(null);
    }

    public PassengerDto create(PassengerDto passengerDto) {
        log.debug("Request to create Passenger : {}", passengerDto);

        return mapToDto(this.passengerRepository.save(
                new Passenger(
                        passengerDto.getNamee(),
                        passengerDto.getSex(),
                        passengerDto.getAge(),
                        passengerDto.getAdress(),
                        passengerDto.getEmployees(),
                        passengerDto.getFlight(),
                        passengerDto.getBooking()
                )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Passenger : {}", id);
        this.passengerRepository.deleteById(id);
    }

    public static PassengerDto mapToDto(Passenger passenger) {
        if (passenger != null) {
            return new PassengerDto(
                    passenger.getId(),
                    passenger.getNamee(),
                    passenger.getSex(),
                    passenger.getAge(),
                    passenger.getAdress(),
                    passenger.getEmployees(),
                    passenger.getFlight(),
                    passenger.getBooking()
            );
        }
        return null;
    }
}
