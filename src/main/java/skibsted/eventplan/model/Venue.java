package skibsted.eventplan.model;


import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Entity
public class Venue {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;

    @ManyToMany (mappedBy ="venuesLiked")// mappedby kommer
    @JsonBackReference
    private Set<User> userLikes = new HashSet<>();
}
