package ci.digitalacademy.forum.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@Entity
@ToString
@Table(name = "sujet")
public class Sujet{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "title")
    private String title;

    @Column(name = "category")
    private String category;

    @Column(name = "date_creation")
    private LocalDate dateCreation;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "forum_id")
    private Forum forum;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "sujet")
    private List<Message> message;
}
