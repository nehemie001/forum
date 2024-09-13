package ci.digitalacademy.forum.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.List;

@Getter
@Setter
public class SujetDTO {

    private Long id;

    private String title;

    private String category;

    private Instant dateCreation;

    private ForumDTO forum;

    private List<MessageDTO> message;

}
