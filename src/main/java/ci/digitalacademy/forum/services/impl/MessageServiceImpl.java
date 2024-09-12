package ci.digitalacademy.forum.services.impl;

import ci.digitalacademy.forum.services.MessageService;
import ci.digitalacademy.forum.services.dto.MessageDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class MessageServiceImpl implements MessageService {

    @Override
    public MessageDTO save(MessageDTO messageDTO) {
        return null;
    }
    

    @Override
    public List<MessageDTO> findAll() {
        return List.of();
    }
}
