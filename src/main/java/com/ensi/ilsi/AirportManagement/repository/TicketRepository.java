package com.ensi.ilsi.AirportManagement.repository;


import com.ensi.ilsi.AirportManagement.domain.Ticket;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository <Ticket, Long> {
}
