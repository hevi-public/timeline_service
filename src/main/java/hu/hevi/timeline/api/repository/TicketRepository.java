package hu.hevi.timeline.api.repository;

import hu.hevi.timeline.api.model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface TicketRepository extends MongoRepository<Ticket, Integer> {
}
