package ci.digitalacademy.forum.services.impl;

import ci.digitalacademy.forum.models.Sujet;
import ci.digitalacademy.forum.repositories.SujetRepository;
import ci.digitalacademy.forum.services.SujetService;
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

    @Override
    public SujetDTO save(SujetDTO sujetDTO) {
        log.debug("Request to save sujet : {} ", sujetDTO);
        Sujet sujet = sujetMapper.toEntity(sujetDTO);
        sujet.setDateCreation(Instant.now());
        sujet = sujetRepository.save(sujet);
        return sujetMapper.toDto(sujet);
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
