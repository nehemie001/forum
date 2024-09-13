package ci.digitalacademy.forum.services.impl;

import ci.digitalacademy.forum.models.Forum;
import ci.digitalacademy.forum.models.Sujet;
import ci.digitalacademy.forum.repositories.ForumRepository;
import ci.digitalacademy.forum.repositories.SujetRepository;
import ci.digitalacademy.forum.services.SujetService;
import ci.digitalacademy.forum.services.dto.ForumDTO;
import ci.digitalacademy.forum.services.dto.SujetDTO;
import ci.digitalacademy.forum.services.mapper.SujetMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SujetServiceImpl implements SujetService {

    private final SujetMapper sujetMapper;
    private final SujetRepository sujetRepository;
    private final ForumRepository forumRepository;

    @Override
    public SujetDTO save(SujetDTO sujetDTO) {
        log.debug("Request to save sujet : {} ", sujetDTO);

        // Convertir SujetDTO en Sujet
        Sujet sujet = sujetMapper.toEntity(sujetDTO);
        // Associer le Forum au Sujet
        Forum forum = forumRepository.findById(sujetDTO.getForum().getId()).orElseThrow(() -> new RuntimeException("Forum not found"));
        sujet.setForum(forum);
        sujet.setDateCreation(Instant.now());
        sujet = sujetRepository.save(sujet);
        // Convertir Sujet en SujetDTO et retourner
        return sujetMapper.toDto(sujet);
    }

    @Override
    public List<SujetDTO> findAllByForum(Long forumId) {
        log.debug("Request to get all sujets by forum : {}", forumId);
        return sujetRepository.findByForumId(forumId)
                .stream()
                .map(sujetMapper::toDto)
                .toList();
    }

    @Override
    public List<SujetDTO> findAll() {
        log.debug("Request to get all sujet : {} ");
        return sujetRepository.findAll().stream().map(sujetMapper::toDto).toList();
    }

    @Override
    public Optional<SujetDTO> findById(Long id) {
        log.debug("Request to get one sujet", id);
        return sujetRepository.findById(id).map(sujetMapper::toDto);
    }

}
