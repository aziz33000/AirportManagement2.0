package com.ensi.ilsi.AirportManagement.web;


import com.ensi.ilsi.AirportManagement.service.PassengerService;
import com.ensi.ilsi.AirportManagement.web.dto.PassengerDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ensi.ilsi.AirportManagement.common.Web.API;

@RestController
@RequestMapping(API + "/passengers")
@Api(value="passenger", description="Operations pertaining to passenger")
public class PassengerResource {

    private final PassengerService passengerService;

    public PassengerResource(PassengerService passengerService){this.passengerService = passengerService;}


    @GetMapping
    public List<PassengerDto> findAll() {
        return this.passengerService.findAll();
    }

    @GetMapping("/{id}")
    public PassengerDto findById(@PathVariable Long id) {
        return this.passengerService.findById(id);
    }

    @PostMapping
    public PassengerDto create(@RequestBody PassengerDto passengerDto) {
        return this.passengerService.create(passengerDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.passengerService.delete(id);
    }
}
