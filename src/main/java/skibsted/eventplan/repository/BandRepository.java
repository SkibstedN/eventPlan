package skibsted.eventplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skibsted.eventplan.model.Band;

public interface BandRepository extends JpaRepository<Band,Long> {
}
