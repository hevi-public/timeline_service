package hu.hevi.timeline.api.controller;

import hu.hevi.timeline.api.controller.response.Overview;
import hu.hevi.timeline.api.controller.response.TicketResponse;
import hu.hevi.timeline.api.domain.update.Update;
import hu.hevi.timeline.api.model.Ticket;
import hu.hevi.timeline.api.repository.TicketRepository;
import hu.hevi.timeline.api.repository.UpdateRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@Slf4j
public class TicketController {

    @Autowired
    private TicketRepository ticketRepository;
    @Autowired
    private UpdateRepository updateRepository;

    @GetMapping(value = "/ticket", produces = "application/json")
    public ResponseEntity<TicketResponse> getTickets() {
        log.info("getTickets()");

        Overview overview = Overview.builder()
                .recentlyUpdatedTickets(ticketRepository.findAll(Sort.by(Sort.Direction.DESC, "updatedAt")))
                .recentComments(new ArrayList<>())
                .build();

        List<Update> updates = updateRepository.findAll();

        List<Ticket> tickets = ticketRepository.findAll();
        tickets.forEach(ticket -> ticket.setUpdates(updates));

        TicketResponse ticketResponse = TicketResponse.builder()
                .tickets(tickets)
                .overview(overview)
                .recentUpdates(updates)
                .build();

        return new ResponseEntity<>(ticketResponse, HttpStatus.OK);
    }

    @PostMapping(value = "/ticket", produces = "application/json")
    public ResponseEntity<Ticket> addTicket(@RequestBody Ticket ticket) {
        log.info("addTicket()");
        return new ResponseEntity<>(ticketRepository.save(ticket), HttpStatus.OK);
    }
}
