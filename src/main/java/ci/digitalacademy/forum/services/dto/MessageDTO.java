package ci.digitalacademy.forum.services.dto;

import ci.digitalacademy.forum.models.Message;
import ci.digitalacademy.forum.models.Sujet;
import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class MessageDTO {

    private Long id;

    private String content;

    private LocalDate dateMessage;

    private Sujet sujet;

}
