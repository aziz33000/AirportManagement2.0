package com.ensi.ilsi.AirportManagement.repository;

import com.ensi.ilsi.AirportManagement.domain.Airline;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface AirlineRepository extends JpaRepository<Airline,Long> {
}
