package com.example.demo.Controller;

import com.example.demo.DTO.CommentDTO;
import com.example.demo.Entity.Comment;
import com.example.demo.Entity.User;
import com.example.demo.Service.CommentService;
import com.example.demo.Service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/comment")
@AllArgsConstructor
public class CommentController {
    private final CommentService commentService;
    private final LikeService likeService;

    @PostMapping("/{publicationId}")
    public CommentDTO addComment(@RequestBody CommentDTO comment,
                                 @PathVariable String publicationId,
                                 Authentication authentication) throws Exception {
        User user = (User) authentication.getPrincipal();
        boolean thereAnyLikeByUserAndPost = likeService.existsThereAnyLikeByUserAndPost(publicationId, user.getId());
        if (!thereAnyLikeByUserAndPost) {
            throw new Exception("There is no like in this post by user");
        }

        return commentService.addComment(comment, publicationId, user.getId());
    }

    @DeleteMapping("/{commentId}")
    public ResponseEntity<Void> deletePostById(@PathVariable String commentId,
                                               Authentication authentication) throws Exception {
        User user = (User) authentication.getPrincipal();
        Comment comment = commentService.findById(commentId);
        if (comment.getPublication().getUser().getId().equals(user.getId())) {
            if (commentService.deleteComment(commentId)) {
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
