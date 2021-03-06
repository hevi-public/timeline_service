package hu.hevi.timeline.api.model;

import hu.hevi.timeline.api.domain.update.Update;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document(collection = "ticket")
public class Ticket {

    @Id
    private Integer id;
    @Indexed(unique = true)
    private String ticketNumber;
    private String description;
    private String title;
    private Type type;
    private Priority priority;
    private Size size;
    private String status;
    private String assignee;
    private String reporter;
    private List<Comment> comments;
    private List<Todo> todos;
    private List<Attachment> attachments;
    private List<Update> updates;

    private String start;
    private String end;
    private String updatedAt;
}
