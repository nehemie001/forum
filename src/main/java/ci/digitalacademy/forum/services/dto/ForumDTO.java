package ci.digitalacademy.forum.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class ForumDTO {

    private Long id;

    private String title;

    private String description;

    private Instant dateCreation;

    private List<SujetDTO> sujet;
}
