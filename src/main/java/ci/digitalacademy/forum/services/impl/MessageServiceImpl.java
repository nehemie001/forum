package ci.digitalacademy.forum.services.impl;

import ci.digitalacademy.forum.models.Message;
import ci.digitalacademy.forum.models.Sujet;
import ci.digitalacademy.forum.repositories.MessageRepository;
import ci.digitalacademy.forum.repositories.SujetRepository;
import ci.digitalacademy.forum.services.MessageService;
import ci.digitalacademy.forum.services.dto.MessageDTO;
import ci.digitalacademy.forum.services.dto.SujetDTO;
import ci.digitalacademy.forum.services.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageMapper messageMapper;
    private final MessageRepository messageRepository;
    private final SujetRepository sujetRepository;

    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        log.debug("Request to save message : {} ", messageDTO);
        Message message = messageMapper.toEntity(messageDTO);
        message.setSujet(sujetRepository.findById(messageDTO.getSujet().getId()).orElse(null)  );
        message.setDateMessage(Instant.now());
        message = messageRepository.save(message);
        return messageMapper.toDto(message);
    }

    @Override
    public List<MessageDTO> findMessageInSujet(Long id) {
        log.debug("Request to get messages in sujet by id:{}", id);
        Sujet sujet = new Sujet();
        sujet.setId(id);
        return messageRepository.findMessageById(id).stream()
                .map(messageMapper::toDto).collect(Collectors
                        .toList());
    }

}
