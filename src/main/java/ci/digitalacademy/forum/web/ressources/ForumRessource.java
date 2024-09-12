package ci.digitalacademy.forum.web.ressources;

import ci.digitalacademy.forum.services.ForumService;
import ci.digitalacademy.forum.services.dto.ForumDTO;
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
@RequestMapping("/api/forums")
public class ForumRessource {

    private final ForumService forumService;

    @PostMapping
    @ApiResponse(responseCode = "200", description = "Forum saved successfully")
    @Operation(summary = "Save a new forum", description = "This endpoint allows to save a new forum")
    public ResponseEntity<ForumDTO> saveForum(@RequestBody ForumDTO forum) {
        log.debug("REST request to save forum : {}", forum);
        return new ResponseEntity<>(forumService.save(forum), HttpStatus.CREATED);
    }


    @GetMapping("/{id}")
    @ApiResponse(responseCode = "200", description = "Forum retrieved successfully")
    @Operation(summary = "Get a forum by its id", description = "This endpoint allows to retrieve a forum by its id")
    public ResponseEntity<?> getForumById(

            @Parameter(required = true, description = "ID of the forum to be retrieved")
            @PathVariable Long id
    ) {

        log.debug("REST request to get forum : {}", id);

        Optional<ForumDTO> forum = forumService.findById(id);
        if (forum.isPresent()) {
            return new ResponseEntity<>(forum.get(), HttpStatus.OK);
        }

        return new ResponseEntity<>("Forum not found", HttpStatus.NOT_FOUND);
    }

    @GetMapping
    @ApiResponses(

            {
                    @ApiResponse(responseCode = "200", description = "List of forums retrieved successfully"),
                    @ApiResponse(responseCode = "404", description = "No forums found", content = @Content(schema = @Schema(implementation = String.class)))
            }
    )

    public List<ForumDTO> getAllForums() {
        log.debug("REST request to get all forums");
        return forumService.findAll();
    }

}
