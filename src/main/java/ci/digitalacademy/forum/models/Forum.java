package ci.digitalacademy.forum.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "forum")
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date_creation", nullable = false)
    private Instant dateCreation;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<Sujet> sujet;
}
