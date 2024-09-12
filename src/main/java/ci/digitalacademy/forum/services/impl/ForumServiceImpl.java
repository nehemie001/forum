package ci.digitalacademy.forum.services.impl;

import ci.digitalacademy.forum.services.ForumService;
import ci.digitalacademy.forum.services.dto.ForumDTO;
import ci.digitalacademy.forum.services.mapper.ForumMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {

    private final ForumService forumService;


    @Override
    public ForumDTO save(ForumDTO forumDTO) {
        log.debug("Request to save forum:{}",forumDTO);

        return null;

    }

    @Override
    public List<ForumDTO> findAll() {
        return List.of();
    }

    @Override
    public Optional<ForumDTO> findById(Long id) {
        return Optional.empty();
    }
}
