package com.example.demo.Service;

import com.example.demo.DTO.CommentDTO;
import com.example.demo.Entity.Comment;
import com.example.demo.Entity.Publication;
import com.example.demo.Entity.User;
import com.example.demo.Repository.CommentRepository;
import com.example.demo.Repository.PublicationRepository;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.stereotype.Service;

@Service
@AllArgsConstructor
public class CommentService {
    private final CommentRepository commentRepository;
    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;

    public Slice<CommentDTO> findCommentByPublicationId(Pageable pageable, String postId) {
        Slice<Comment> comments = commentRepository.findAllByPublicationId(pageable, postId);
        return comments.map(CommentDTO::from);
    }

    public CommentDTO addComment(CommentDTO commentData, String publicationId, String userId) throws Exception {
        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new Exception("There is not such a post with " + publicationId + "id"));

        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("There is no such a user with " + userId + " id"));
        return CommentDTO.from(commentRepository.save(Comment.createComment(publication, commentData.getMessage(), commentData.getLocalDate(), user)));
    }

    public boolean deleteComment(String commentId) {
        commentRepository.deleteById(commentId);
        return true;
    }

    public Comment findById(String id) throws Exception {
        return commentRepository.findById(id).orElseThrow(()->
                new Exception("There is no such comment"));
    }
}
