/**
 * NOTE: This class is auto generated by OpenAPI Generator (https://openapi-generator.tech) (6.0.1).
 * https://openapi-generator.tech
 * Do not edit the class manually.
 */
package sk.best.newtify.api;

import sk.best.newtify.api.dto.CommentDTO;
import sk.best.newtify.api.dto.CreateCommentDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import javax.validation.constraints.*;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import javax.annotation.Generated;

@Generated(value = "org.openapitools.codegen.languages.SpringCodegen", date = "2022-07-15T14:11:33.660158200+02:00[Europe/Vienna]")
@Validated
@Tag(name = "Comments", description = "the Comments API")
public interface CommentsApi {

    /**
     * POST /v1/comments
     * This is the endpoint which will create a comment
     *
     * @param createCommentDTO Data model for comment creation (required)
     * @return Hey, everything went well (status code 201)
     */
    @Operation(
        operationId = "createComment",
        tags = { "comments" },
        responses = {
            @ApiResponse(responseCode = "201", description = "Hey, everything went well", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = CommentDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.POST,
        value = "/v1/comments",
        produces = { "application/json" },
        consumes = { "application/json" }
    )
    ResponseEntity<CommentDTO> createComment(
        @Parameter(name = "CreateCommentDTO", description = "Data model for comment creation", required = true) @Valid @RequestBody CreateCommentDTO createCommentDTO
    );


    /**
     * GET /v1/comments
     * Endpoint to retrieve all comments
     *
     * @param articleUuid  (optional)
     * @return returns comments (status code 200)
     */
    @Operation(
        operationId = "retrieveComment",
        tags = { "comments" },
        responses = {
            @ApiResponse(responseCode = "200", description = "returns comments", content = {
                @Content(mediaType = "application/json", schema = @Schema(implementation = CommentDTO.class))
            })
        }
    )
    @RequestMapping(
        method = RequestMethod.GET,
        value = "/v1/comments",
        produces = { "application/json" }
    )
    ResponseEntity<CommentDTO> retrieveComment(
        @Parameter(name = "articleUuid", description = "") @PathVariable("articleUuid") String articleUuid
    );

}
