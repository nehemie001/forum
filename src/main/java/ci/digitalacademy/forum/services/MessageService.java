package ci.digitalacademy.forum.services;

import ci.digitalacademy.forum.services.dto.MessageDTO;
import ci.digitalacademy.forum.services.dto.SujetDTO;

import java.util.List;
import java.util.Optional;

public interface MessageService {
    MessageDTO save(MessageDTO messageDTO);


    List<MessageDTO> findMessageInSujet(Long id);


}
