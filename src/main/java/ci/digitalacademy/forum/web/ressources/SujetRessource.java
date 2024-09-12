package ci.digitalacademy.forum.web.ressources;

import ci.digitalacademy.forum.services.SujetService;
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
    public ResponseEntity<SujetDTO> saveSujet(@RequestBody SujetDTO sujet) {
        log.debug("REST request to save Sujet : {}", sujet);
        return new ResponseEntity<>(sujetService.save(sujet), HttpStatus.CREATED);
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
}
