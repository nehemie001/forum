package ci.digitalacademy.forum.web.ressources;

import ci.digitalacademy.forum.services.MessageService;
import ci.digitalacademy.forum.services.dto.MessageDTO;
import io.swagger.v3.oas.annotations.Operation;
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

@RestController
@RequiredArgsConstructor
@Slf4j
@RequestMapping("/api/messages")
public class MessageRessource {

    public final MessageService messageService;

    @PostMapping
    @ApiResponse(responseCode = "201", description = "Message saved successfully"  )
    @Operation(summary = "Save a new message", description = "This endpoint allows to save a new message")
    public ResponseEntity<MessageDTO> saveMessage(@RequestBody MessageDTO message) {
        log.debug("REST request to Save message: {}", message);
        return new ResponseEntity<>(messageService.save(message), HttpStatus.CREATED);
    }


    @GetMapping
    @ApiResponses(

            {
                    @ApiResponse(responseCode = "200", description = "List of messages found successfully" ),
                    @ApiResponse(responseCode = "404", description = "No messages found", content = @Content(schema = @Schema(implementation = String.class)))
            }
    )

    public List<MessageDTO> getAllMessages() {
        log.debug("REST request to Get all messages");
        return messageService.findAll();
    }

}
