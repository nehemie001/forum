package ci.digitalacademy.forum.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.io.Serializable;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@Entity
@Table(name = "message")
public class Message implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "content", nullable = false)
    private String content;

    @Column(name = "date_message", nullable = false)
    private LocalDate dateMessage;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "sujet_id")
    private Sujet sujet;

}
