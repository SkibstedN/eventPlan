package skibsted.eventplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skibsted.eventplan.model.Review;

public interface ReviewRepository extends JpaRepository<Review,Long> {
}
