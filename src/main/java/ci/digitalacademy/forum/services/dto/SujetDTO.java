package ci.digitalacademy.forum.services.dto;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;
import java.util.Set;

@Getter
@Setter
public class SujetDTO {

    private Long id;

    private String title;

    private String category;

    private LocalDate dateCreation;

    private List<MessageDTO> message;
}
