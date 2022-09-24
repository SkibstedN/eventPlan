package skibsted.eventplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skibsted.eventplan.model.Event;

public interface EventRepository extends JpaRepository<Event,Long> {
}
