package ci.digitalacademy.forum.services.dto;

import lombok.Getter;
import lombok.Setter;

import java.time.Instant;

@Getter
@Setter
public class MessageDTO {

    private Long id;

    private String content;

    private Instant dateMessage;

    private SujetDTO sujet;

}
