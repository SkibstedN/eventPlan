package skibsted.eventplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skibsted.eventplan.model.Venue;

public interface VenueRepository extends JpaRepository<Venue,Long> {
}
