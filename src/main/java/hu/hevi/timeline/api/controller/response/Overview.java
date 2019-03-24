package hu.hevi.timeline.api.controller.response;

import hu.hevi.timeline.api.model.Comment;
import hu.hevi.timeline.api.model.Ticket;
import lombok.Builder;
import lombok.Value;

import java.util.List;

@Value
@Builder
public class Overview {

    private List<Ticket> recentlyUpdatedTickets;
    private List<Comment> recentComments;
}
