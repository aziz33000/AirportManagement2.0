package com.ensi.ilsi.AirportManagement.web;


import com.ensi.ilsi.AirportManagement.service.EmployeeService;
import com.ensi.ilsi.AirportManagement.web.dto.EmployeeDto;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static com.ensi.ilsi.AirportManagement.common.Web.API;

@RestController
@RequestMapping(API + "/employees")
@Api(value="employee", description="Operations pertaining to employees")
public class EmployeeResource {
    private final EmployeeService employeeService;

    public EmployeeResource(EmployeeService employeeService){this.employeeService = employeeService;}


    @GetMapping
    public List<EmployeeDto> findAll() {
        return this.employeeService.findAll();
    }

    @GetMapping("/{id}")
    public EmployeeDto findById(@PathVariable Long id) {
        return this.employeeService.findById(id);
    }

    @PostMapping
    public EmployeeDto create(@RequestBody EmployeeDto employeeDto) {
        return this.employeeService.create(employeeDto);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        this.employeeService.delete(id);
    }

}
