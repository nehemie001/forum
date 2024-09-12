package ci.digitalacademy.forum.services.dto;

import ci.digitalacademy.forum.models.Sujet;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class ForumDTO {

    private Long id;

    private String title;

    private String description;

    private LocalDate dateCreation;

    private List<SujetDTO> sujet;
}
