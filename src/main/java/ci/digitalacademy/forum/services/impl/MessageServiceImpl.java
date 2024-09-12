package ci.digitalacademy.forum.services.impl;

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

    private final MessageService messageService;
    private final MessageMapper messageMapper;
    private final MessageRepository messageRepository;

    @Override
    public MessageDTO save(MessageDTO messageDTO) {

        return messageMapper.toDto(messageRepository.save(messageMapper.toEntity(messageDTO)));
    }


    @Override
    public List<MessageDTO> findAll() {

        return messageRepository.findAll().stream().map(message -> messageMapper.toDto(message)).toList();
    }
}
