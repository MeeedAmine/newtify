package sk.best.newtify.backend.service;

import org.springframework.stereotype.Service;
import sk.best.newtify.api.dto.CommentDTO;
import sk.best.newtify.api.dto.CreateCommentDTO;
import sk.best.newtify.backend.entity.Comment;
import sk.best.newtify.backend.repository.CommentRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class CommentService {

    private CommentRepository commentRepository;

    public CommentService(CommentRepository commentRepository) {
        this.commentRepository = commentRepository;
    }

    public CommentDTO createComment(CreateCommentDTO createCommentDTO){
        Comment comment = new Comment();
        comment.setAuthor(createCommentDTO.getAuthor());
        comment.setText(createCommentDTO.getText());
        comment.setArticleId(createCommentDTO.getArticleID());
        comment.setCreatedAt(createCommentDTO.getCreatedAt());

        commentRepository.save(comment);

        CommentDTO commentDTO = new CommentDTO();
        commentDTO.setUuid(comment.getUuid());
        commentDTO.setAuthor(comment.getAuthor());
        commentDTO.setText(comment.getText());
        commentDTO.setArticleId(comment.getArticleId());
        commentDTO.setCreatedAt(comment.getCreatedAt());

        return commentDTO;
    }

    public List<CommentDTO> retrieveComments(String articleID){
        List<Comment> comments = new ArrayList<>();
        comments = commentRepository.findAllByArticleId(articleID);

        List<CommentDTO> response = new ArrayList<>();

        for(Comment comment: comments){
            CommentDTO commentDTO = new CommentDTO();

            commentDTO.setUuid(comment.getUuid());
            commentDTO.setAuthor(comment.getAuthor());
            commentDTO.setText(comment.getText());
            commentDTO.setArticleId(comment.getArticleId());
            commentDTO.setCreatedAt(comment.getCreatedAt());
        }

        return response;
    }
}
