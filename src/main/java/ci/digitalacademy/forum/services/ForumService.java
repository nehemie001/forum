package ci.digitalacademy.forum.services;

import ci.digitalacademy.forum.services.dto.ForumDTO;
import ci.digitalacademy.forum.services.dto.SujetDTO;

import java.util.List;
import java.util.Optional;

public interface ForumService {

    ForumDTO save(ForumDTO forumDTO);

    List<ForumDTO> findAll();

//    Optional<ForumDTO> findOne(Long id);

    Optional<ForumDTO> findById(Long id);
}
