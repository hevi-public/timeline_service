package hu.hevi.timeline.api.repository;

import hu.hevi.timeline.api.domain.update.Update;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface UpdateRepository extends MongoRepository<Update, Integer> {
}
