package com.ensi.ilsi.AirportManagement.web;

import com.ensi.ilsi.AirportManagement.service.CityService;
import com.ensi.ilsi.AirportManagement.web.dto.CityDto;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ensi.ilsi.AirportManagement.common.Web.API;

@RestController
@RequestMapping(API + "/cities")
public class CityResource {
    private final CityService cityService;

    public CityResource(CityService cityService){this.cityService = cityService;}


    @GetMapping
    public List<CityDto> findAll() {
        return this.cityService.findAll();
    }

    @GetMapping("/{id}")
    public CityDto findById(@PathVariable Long id) {
        return this.cityService.findById(id);
    }

    @PostMapping
    public CityDto create(@RequestBody CityDto cityDto) {
        return this.cityService.create(cityDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.cityService.delete(id);
    }
}
