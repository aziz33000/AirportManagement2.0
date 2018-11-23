package com.ensi.ilsi.AirportManagement.web;


import com.ensi.ilsi.AirportManagement.service.TicketService;
import com.ensi.ilsi.AirportManagement.web.dto.TicketDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ensi.ilsi.AirportManagement.common.Web.API;

@RestController
@RequestMapping(API + "/tickets")
@Api(value="ticket", description="Operations pertaining to tickets")
public class TicketResource {

    private final TicketService ticketService;

    public TicketResource(TicketService ticketService){this.ticketService = ticketService;}


    @GetMapping
    public List<TicketDto> findAll() {
        return this.ticketService.findAll();
    }

    @GetMapping("/{id}")
    public TicketDto findById(@PathVariable Long id) {
        return this.ticketService.findById(id);
    }

    @PostMapping
    public TicketDto create(@RequestBody TicketDto ticketDto) {
        return this.ticketService.create(ticketDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.ticketService.delete(id);
    }
}
