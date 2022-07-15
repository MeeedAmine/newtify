package sk.best.newtify.web.connector;


import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import sk.best.newtify.api.CommentsApi;
import sk.best.newtify.api.dto.ArticleDTO;
import sk.best.newtify.api.dto.CommentDTO;
import sk.best.newtify.api.dto.CreateArticleDTO;
import sk.best.newtify.api.dto.CreateCommentDTO;

import java.util.Collections;
import java.util.List;

@Slf4j
@Service
public class CommentConnectorService implements CommentsApi {

    private static final String COMMENTS_API_URL = "http://localhost:8081/v1/comments";

    private final RestTemplate restTemplate = new RestTemplate();

    @Override
    public ResponseEntity<CommentDTO> createComment(@NonNull CreateCommentDTO createCommentDTO) {
        try {
            return restTemplate.postForEntity(COMMENTS_API_URL, createCommentDTO, CommentDTO.class);
        } catch (Exception e) {
            log.error("ERROR createArticle", e);
            return ResponseEntity
                    .internalServerError()
                    .build();
        }
    }

    @Override
    public ResponseEntity<List<CommentDTO>> retrieveComment(@NonNull String articleId){
        try {
            ResponseEntity<CommentDTO[]> commentsResponse;
            if (articleId == null) {
                commentsResponse = restTemplate.getForEntity(COMMENTS_API_URL, CommentDTO[].class);
            } else {
                commentsResponse = restTemplate.getForEntity(COMMENTS_API_URL, CommentDTO[].class);
            }

            CommentDTO[] data = commentsResponse.getBody();
            if (data == null) {
                return ResponseEntity.ok(Collections.emptyList());
            }

            return ResponseEntity
                    .status(commentsResponse.getStatusCode())
                    .body(List.of(data));
        } catch (Exception e) {
            log.error("ERROR retrieveArticles", e);
            return ResponseEntity
                    .internalServerError()
                    .body(Collections.emptyList());
        }
    }
}
