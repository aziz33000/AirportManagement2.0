package com.ensi.ilsi.AirportManagement.repository;

import com.ensi.ilsi.AirportManagement.domain.Passenger;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassengerRepository extends JpaRepository <Passenger, Long> {
}
