package ci.digitalacademy.forum.services.impl;

import ci.digitalacademy.forum.services.SujetService;
import ci.digitalacademy.forum.services.dto.SujetDTO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class SujetServiceImpl implements SujetService {

    private final SujetService sujetService;

    @Override
    public SujetDTO save(SujetDTO sujetDTO) {
        return null;
    }

    @Override
    public List<SujetDTO> findAll() {
        return List.of();
    }

    @Override
    public Optional<SujetDTO> findOne(Long id) {
        return Optional.empty();
    }
}
