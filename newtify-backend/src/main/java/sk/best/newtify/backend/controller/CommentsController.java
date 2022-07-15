package sk.best.newtify.backend.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import sk.best.newtify.api.CommentsApi;
import sk.best.newtify.api.dto.CommentDTO;
import sk.best.newtify.api.dto.CreateCommentDTO;
import sk.best.newtify.backend.service.CommentService;

import java.util.List;

public class CommentsController implements CommentsApi {

    @Autowired
    private CommentService commentService;

    @Override
    public ResponseEntity<CommentDTO> createComment(CreateCommentDTO createCommentDTO) {
        CommentDTO response = commentService.createComment(createCommentDTO);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @Override
    public ResponseEntity<List<CommentDTO>> retrieveComment(String articleUuid) {
        List<CommentDTO> commentList = commentService.retrieveComments(articleUuid);
        return ResponseEntity.status(HttpStatus.OK).body(commentList);
    }
}
