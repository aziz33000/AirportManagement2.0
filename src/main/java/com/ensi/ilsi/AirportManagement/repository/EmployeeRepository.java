package com.ensi.ilsi.AirportManagement.repository;


import com.ensi.ilsi.AirportManagement.domain.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmployeeRepository extends JpaRepository <Employee,Long> {
}
