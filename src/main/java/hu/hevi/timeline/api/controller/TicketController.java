package hu.hevi.timeline.api.controller;

import hu.hevi.timeline.api.model.Ticket;
import hu.hevi.timeline.api.repository.TicketRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@Slf4j
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;

    @GetMapping(value = "/ticket", produces = "application/json")
    public ResponseEntity<List<Ticket>> getTickets() {
        log.info("getTickets()");
        return new ResponseEntity<>(ticketRepository.findAll(), HttpStatus.OK);
    }

    @PostMapping(value = "/ticket", produces = "application/json")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
        log.info("addTicket()");
        return new ResponseEntity<>(ticketRepository.save(ticket), HttpStatus.OK);
    }
}
