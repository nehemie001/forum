package ci.digitalacademy.forum.web.ressources;


import ci.digitalacademy.forum.services.SujetService;
import ci.digitalacademy.forum.services.dto.ForumDTO;
import ci.digitalacademy.forum.services.dto.SujetDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/sujets")
public class SujetRessource {

    private final SujetService sujetService;

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Sujet saved successfully")
    @Operation(summary = "Save a new sujet", description = "This endpoint allows to save a")
    public ResponseEntity<SujetDTO> saveSujet(@RequestBody SujetDTO sujetDTO) {

        log.debug("REST request to save Sujet : {}", sujetDTO);
        if (sujetDTO.getForum() == null || sujetDTO.getForum().getId() == null) {
            return ResponseEntity.badRequest().body(null);
        }
        SujetDTO sujet = sujetService.save(sujetDTO);
        return new ResponseEntity<>(sujet, HttpStatus.CREATED);

    }

    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Return a single sujet")
    @Operation(summary = "Find a sujet by its id", description = "This endpoint allows to find a single")
    public ResponseEntity<?> findById(

            @Parameter(required = true, description = "ID of the sujet to be retrieved")
            @PathVariable Long id
    ) {

        log.debug("REST request to get Sujet : {}", id);

        Optional<SujetDTO> sujet = sujetService.findById(id);

        if (sujet.isPresent()) {
            return new ResponseEntity<>(sujet.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>("Sujet not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping
    @ApiResponses(
            {
                    @ApiResponse(responseCode = "200", description = "Return all the sujets"),
                    @ApiResponse(responseCode = "404", description = "No sujets found", content = @Content(schema = @Schema(implementation = String.class)))
            }
    )

    public List<SujetDTO> findAll() {
        log.debug("REST request to get all Sujets");
        return sujetService.findAll();
    }

    @GetMapping("/slug/{slug}")
    @ApiResponse(responseCode = "200", description = "Return a sujet by its slug")
    @Operation(summary = "Find a sujet by its slug", description = "This endpoint allows to find a sujet by its slug")
    public ResponseEntity<SujetDTO> findSujetBySlug(
            @Parameter(required = true, description = "Slug of the sujet to be retrieved")
            @PathVariable String slug
    ) {
        log.debug("REST request to get Forum by slug : {}", slug);
        Optional<SujetDTO> forum = sujetService.findBySlug(slug);
        if (forum.isPresent()) {
            return new ResponseEntity<>(forum.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
