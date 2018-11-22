package com.ensi.ilsi.AirportManagement.repository;

import com.ensi.ilsi.AirportManagement.domain.Airport;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AirportRepository extends JpaRepository <Airport,Long> {

}
