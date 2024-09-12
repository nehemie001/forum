package ci.digitalacademy.forum.services;

import ci.digitalacademy.forum.services.dto.ForumDTO;

import java.util.List;
import java.util.Optional;

public interface ForumService {

    ForumDTO save(ForumDTO forumDTO);

    List<ForumDTO> findAll();

    Optional<ForumDTO> findById(Long id);
}
