package ci.digitalacademy.forum.services;

import ci.digitalacademy.forum.services.dto.ForumDTO;
import ci.digitalacademy.forum.services.dto.SujetDTO;

import java.util.List;
import java.util.Optional;

public interface SujetService {

    SujetDTO save(SujetDTO sujetDTO);

    List<SujetDTO> findAll();

    Optional<SujetDTO> findById(Long id);

    Optional<SujetDTO> findBySlug(String slug);

}
