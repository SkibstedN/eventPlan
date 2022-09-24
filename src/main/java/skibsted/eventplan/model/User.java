package skibsted.eventplan.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Data;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;
import java.util.HashSet;
import java.util.Set;

@Data
@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    @ManyToMany
    @JoinTable(
            name = "venue like",
            joinColumns = @JoinColumn(name = "user id"),
            inverseJoinColumns = @JoinColumn(name = "venue_id")
    )
            @JsonBackReference
            private Set<Venue> venuesLiked = new HashSet<>();


    Timestamp timestamp = Timestamp.from(Instant.now());
}
