package ci.digitalacademy.forum.services;

import ci.digitalacademy.forum.services.dto.MessageDTO;

import java.util.List;

public interface MessageService {
    MessageDTO save(MessageDTO messageDTO);

//    List<MessageDTO> findAllBySujet(Long sujetId);  // Récupérer les messages par Sujet

    List<MessageDTO> findAll();

}
