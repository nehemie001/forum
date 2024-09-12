package ci.digitalacademy.forum.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "forum")
@ToString
public class Forum {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title", nullable = false)
    private String title;

    @Column(name = "description", nullable = false)
    private String description;

    @Column(name = "date_creation", nullable = false)
    private LocalDate dateCreation;

    @OneToMany(mappedBy = "forum", cascade = CascadeType.ALL)
    @Column(nullable = true)
    private List<Sujet> sujet;
}
