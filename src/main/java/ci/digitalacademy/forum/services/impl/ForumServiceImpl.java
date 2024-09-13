package ci.digitalacademy.forum.services.impl;

import ci.digitalacademy.forum.models.Forum;
import ci.digitalacademy.forum.repositories.ForumRepository;
import ci.digitalacademy.forum.services.ForumService;
import ci.digitalacademy.forum.services.dto.ForumDTO;
import ci.digitalacademy.forum.services.mapper.ForumMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class ForumServiceImpl implements ForumService {

    private final ForumRepository forumRepository;
    private final ForumMapper forumMapper;

    @Override
    public ForumDTO save(ForumDTO forumDTO) {
        log.debug("Request to save forum:{}", forumDTO);
        Forum forum = forumMapper.toEntity(forumDTO);
        forum.setDateCreation(Instant.now());
        forum = forumRepository.save(forum);
        return forumMapper.toDto(forum);
    }

    @Override
    public List<ForumDTO> findAll() {
        log.debug("Request to get all forums");
        return forumRepository.findAll().stream().map(forumMapper::toDto).toList();
    }

    @Override
    public Optional<ForumDTO> findById(Long id) {
        log.debug("Request to get forum by id:{}", id);
        return forumRepository.findById(id).map(forumMapper::toDto);
    }

    @Override
    public Optional<ForumDTO> findBySlug(String slug) {
        log.debug("Request to get forum by slug:{}", slug);
        return forumRepository.findBySlug(slug).map(forumMapper::toDto);
    }

    public Forum getForumById(Long id) {
        log.debug("Request to get forum by id:{}", id);
        return forumRepository.findById(id).orElseThrow(() -> new IllegalArgumentException());
    }

}
