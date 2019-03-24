package hu.hevi.timeline.api.controller.response;

import hu.hevi.timeline.api.model.Ticket;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class TicketResponse {

    private List<Ticket> tickets;
}