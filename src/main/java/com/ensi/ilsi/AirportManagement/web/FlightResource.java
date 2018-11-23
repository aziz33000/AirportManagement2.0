package com.ensi.ilsi.AirportManagement.web;

import com.ensi.ilsi.AirportManagement.service.FlightService;
import com.ensi.ilsi.AirportManagement.web.dto.FlightDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ensi.ilsi.AirportManagement.common.Web.API;

@RestController
@RequestMapping(API + "/flights")
@Api(value="flight", description="Operations pertaining to flights")
public class FlightResource {


    private final FlightService flightService;

    public FlightResource(FlightService flightService){this.flightService = flightService;}


    @GetMapping
    public List<FlightDto> findAll() {
        return this.flightService.findAll();
    }

    @GetMapping("/{id}")
    public FlightDto findById(@PathVariable Long id) {
        return this.flightService.findById(id);
    }

    @PostMapping
    public FlightDto create(@RequestBody FlightDto flightDto) {
        return this.flightService.create(flightDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.flightService.delete(id);
    }
}
