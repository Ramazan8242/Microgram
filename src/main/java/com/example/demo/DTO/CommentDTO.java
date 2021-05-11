package com.example.demo.DTO;

import com.example.demo.Entity.Comment;
import com.example.demo.Entity.Publication;
import com.example.demo.Entity.User;
import lombok.*;
import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class CommentDTO {
    private Publication publication;
    private String message;
    private LocalDate localDate;
    private User user;

    public static CommentDTO from(Comment comment) {
        return builder()
                .publication(comment.getPublication())
                .message(comment.getMessage())
                .localDate(comment.getLocalDate())
                .user(comment.getUser())
                .build();
    }
}
