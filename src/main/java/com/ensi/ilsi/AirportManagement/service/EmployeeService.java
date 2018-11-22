package com.ensi.ilsi.AirportManagement.service;

import com.ensi.ilsi.AirportManagement.domain.Employee;
import com.ensi.ilsi.AirportManagement.repository.EmployeeRepository;
import com.ensi.ilsi.AirportManagement.web.dto.EmployeeDto;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;


import java.util.List;

import java.util.Set;
import java.util.stream.Collectors;

@Service
@Transactional
public class EmployeeService {

    private final Logger log = LoggerFactory.getLogger(EmployeeService.class);

    private final EmployeeRepository employeeRepository;

    public EmployeeService(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    public List<EmployeeDto> findAll(){
        log.debug("Request to get all Employees");
        return this.employeeRepository.findAll()
                .stream()
                .map(EmployeeService::mapToDto)
                .collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EmployeeDto findById(Long id) {
        log.debug("Request to get Employee: {}", id);
        return this.employeeRepository.findById(id).map(EmployeeService::mapToDto).orElse(null);
    }

    public EmployeeDto create(EmployeeDto employeeDto) {
        log.debug("Request to create Employee : {}", employeeDto);

        return mapToDto(this.employeeRepository.save(
                new Employee(
                        employeeDto.getName(),
                        employeeDto.getSex(),
                        employeeDto.getAdress(),
                        employeeDto.getAge(),
                        employeeDto.getSalary(),
                        employeeDto.getJobType(),
                        employeeDto.getAirport(),
                        employeeDto.getPassengers()


                )));
    }

    public void delete(Long id) {
        log.debug("Request to delete Employee : {}", id);
        this.employeeRepository.deleteById(id);
    }

    public static EmployeeDto mapToDto(Employee employee) {
        if (employee != null) {
            return new EmployeeDto(
                    employee.getId(),
                    employee.getName(),
                    employee.getSex(),
                    employee.getAdress(),
                    employee.getAge(),
                    employee.getSalary(),
                    employee.getJobType(),
                    employee.getAirport(),
                    employee.getPassengers()
            );
        }
        return null;
    }
}
