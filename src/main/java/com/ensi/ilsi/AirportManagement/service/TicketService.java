package com.ensi.ilsi.AirportManagement.service;

import com.ensi.ilsi.AirportManagement.domain.Ticket;
import com.ensi.ilsi.AirportManagement.repository.TicketRepository;
import com.ensi.ilsi.AirportManagement.web.dto.TicketDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class TicketService {

    private final Logger log = LoggerFactory.getLogger(TicketService.class);

    private final TicketRepository ticketRepository;

    public TicketService(TicketRepository ticketRepository) {
        this.ticketRepository = ticketRepository;
    }

    public List<TicketDto> findAll(){
        log.debug("Request to get all Tickets");
        return this.ticketRepository.findAll()
                .stream()
                .map(TicketService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public TicketDto findById(Long id) {
        log.debug("Request to get Ticket : {}", id);
        return this.ticketRepository.findById(id).map(TicketService::mapToDto).orElse(null);
    }

    public TicketDto create(TicketDto ticketDto) {
        log.debug("Request to create Ticket : {}", ticketDto);

        return mapToDto(this.ticketRepository.save(
                new Ticket(
                        ticketDto.getTicketNumber(),
                        ticketDto.getPrice(),
                        ticketDto.getSource(),
                        ticketDto.getDestination(),
                        ticketDto.getTicketClass(),
                        ticketDto.getPassenger()
                )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Ticket : {}", id);
        this.ticketRepository.deleteById(id);
    }

    public static TicketDto mapToDto(Ticket ticket) {
        if (ticket != null) {
            return new TicketDto(
                    ticket.getId(),
                    ticket.getTicketNumber(),
                    ticket.getPrice(),
                    ticket.getSource(),
                    ticket.getDestination(),
                    ticket.getTicketClass(),
                    ticket.getPassenger()
            );
        }
        return null;
    }
}
