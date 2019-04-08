package hu.hevi.timeline.api.domain.update;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "update")
public class Update {

    private String event;
    private String ticketNumber;
    private String description;
    private String date;
}
