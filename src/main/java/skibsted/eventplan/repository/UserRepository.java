package skibsted.eventplan.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import skibsted.eventplan.model.User;

public interface UserRepository extends JpaRepository<User,Long> {

}
