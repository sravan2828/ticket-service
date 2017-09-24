package com.service.tickets.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.service.tickets.database.TicketDAO;
import com.service.tickets.model.Ticket;

@RestController
@RequestMapping("/api")
public class TicketController {
	
	@Autowired
	TicketDAO ticketDao;
	
	@GetMapping("/user")
    public List<Ticket> getAllTickets() {
        return ticketDao.findAll();
    }
	
	@GetMapping("/user/{username}")
    public ResponseEntity<Ticket> getPriorityTicketsByUsername(@PathVariable(value = "username") Long username) {
        Ticket ticket = ticketDao.findOne(username);
        if(ticket == null) {
            return ResponseEntity.notFound().build();
        }
        return ResponseEntity.ok().body(ticket);
    }
	
	@PostMapping("/user")
    public Ticket createTicket(@Valid @RequestBody Ticket ticket) {
        return ticketDao.save(ticket);
    }

    @PutMapping("/user/{id}")
    public ResponseEntity<Ticket> updateTicket(@PathVariable(value = "id") Long ticketId,
                                           @Valid @RequestBody Ticket ticketDetails) {
        Ticket ticket = ticketDao.findOne(ticketId);
        if(ticket == null) {
            return ResponseEntity.notFound().build();
        }
        ticket.setTicket_type(ticketDetails.getTicket_type());
        ticket.setTicket_category(ticketDetails.getTicket_category());

        Ticket updatedTicket = ticketDao.save(ticket);
        return ResponseEntity.ok(updatedTicket);
    }

    @DeleteMapping("/user/{id}")
    public ResponseEntity<Ticket> deleteTicket(@PathVariable(value = "id") Long ticketId) {
        Ticket ticket = ticketDao.findOne(ticketId);
        if(ticket == null) {
            return ResponseEntity.notFound().build();
        }

        ticketDao.delete(ticket);
        return ResponseEntity.ok().build();
    }
	

}
