package com.ensi.ilsi.AirportManagement.web;

import com.ensi.ilsi.AirportManagement.service.AirlineService;
import com.ensi.ilsi.AirportManagement.web.dto.AirlineDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ensi.ilsi.AirportManagement.common.Web.API;

@RestController
@RequestMapping(API + "/airlines")
public class AirlineResource {
    private final AirlineService airlineService;

    public AirlineResource(AirlineService airlineService){this.airlineService = airlineService;}

    @GetMapping
    public List<AirlineDto> findAll() {
        return this.airlineService.findAll();
    }

    @GetMapping("/{id}")
    public AirlineDto findById(@PathVariable Long id) {
        return this.airlineService.findById(id);
    }
    
    @PostMapping
    public AirlineDto create(@RequestBody AirlineDto airlineDto) {
        return this.airlineService.create(airlineDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.airlineService.delete(id);
    }
}
