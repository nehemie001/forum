package ci.digitalacademy.forum.services;

import ci.digitalacademy.forum.services.dto.SujetDTO;

import java.util.List;
import java.util.Optional;

public interface SujetService {

    SujetDTO save(SujetDTO sujetDTO);

    List<SujetDTO> findAll();

    Optional<SujetDTO> findOne(Long id);
}
