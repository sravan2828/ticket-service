package com.service.tickets.database;

import org.springframework.data.jpa.repository.JpaRepository;

import com.service.tickets.model.Ticket;

public interface TicketDAO extends JpaRepository<Ticket, Long> {

}
