package ci.digitalacademy.forum.services.impl;

import ci.digitalacademy.forum.models.Forum;
import ci.digitalacademy.forum.repositories.ForumRepository;
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

    private  final ForumMapper forumMapper;
    private  final ForumRepository forumRepository;


    @Override
    public ForumDTO save(ForumDTO forumDTO) {
        log.debug("Request to save forum:{}",forumDTO);
        Forum forum = forumMapper.toEntity(forumDTO);
        forum = forumRepository.save(forum);
        return forumMapper.toDto(forum);
    }

    @Override
    public List<ForumDTO> findAll() {
        return forumRepository.findAll().stream().map(forum -> {
            return forumMapper.toDto(forum);
        }).toList();
    }


    @Override
    public Optional<ForumDTO> findById(Long id) {
        return forumRepository.findById(id).map(forum -> {
            return  forumMapper.toDto(forum);
        });
    }
}
