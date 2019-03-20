package hu.hevi.timeline.api.model;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "ticket")
public class Ticket {

    @Id
    private Integer id;
    @Indexed(unique = true)
    private String ticketNumber;
    private String description;
    private String start;
    private String end;

}
