package ci.digitalacademy.forum.services.impl;

import ci.digitalacademy.forum.models.Message;
import ci.digitalacademy.forum.models.Sujet;
import ci.digitalacademy.forum.repositories.MessageRepository;
import ci.digitalacademy.forum.services.MessageService;
import ci.digitalacademy.forum.services.dto.MessageDTO;
import ci.digitalacademy.forum.services.mapper.MessageMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    private final MessageMapper messageMapper;
    private final MessageRepository messageRepository;

    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        log.debug("Request to save message : {} ", messageDTO);
        Message message = messageMapper.toEntity(messageDTO);
        message = messageRepository.save(message);
        return messageMapper.toDto(message);
    }
    

    @Override
    public List<MessageDTO> findAll() {
        log.debug("Request to get all messages : {} ");
        return messageRepository.findAll().stream().map(messageMapper::toDto).toList();
    }
}
