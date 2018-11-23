package com.ensi.ilsi.AirportManagement.web;


import com.ensi.ilsi.AirportManagement.domain.Airport;
import com.ensi.ilsi.AirportManagement.service.AirportService;
import com.ensi.ilsi.AirportManagement.web.dto.AirportDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ensi.ilsi.AirportManagement.common.Web.API;

@RestController
@RequestMapping(API + "/airports")
@Api(value="airport", description="Operations pertaining to airports")
public class AirportResource {
    private final AirportService airportService;

    public AirportResource(AirportService airportService) {
        this.airportService = airportService;
    }

    @GetMapping
    public List<AirportDto> findAll() {
        return this.airportService.findAll();
    }

    @GetMapping("/{id}")
    public AirportDto findById(@PathVariable Long id) {
        return this.airportService.findById(id);
    }

    @PostMapping
    public AirportDto create(@RequestBody AirportDto airportDto) {
        return this.airportService.create(airportDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.airportService.delete(id);
    }
}
