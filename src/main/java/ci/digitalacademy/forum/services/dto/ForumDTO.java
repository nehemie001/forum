package ci.digitalacademy.forum.services.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
public class ForumDTO {

    private Long id;

    private String title;

    private String description;

    private String slug;

    private Instant dateCreation;

}
