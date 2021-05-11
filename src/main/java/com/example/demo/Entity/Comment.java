package com.example.demo.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Document(collection = "comments")
public class Comment {

    @Id
    private String id = UUID.randomUUID().toString();
    private Publication publication;
    private String message;
    private LocalDate localDate;
    @DBRef
    private User user;

    public static Comment createComment(Publication publication, String message, LocalDate localDate, User user) {
        Comment comment = new Comment();
        comment.setPublication(publication);
        comment.setMessage(message);
        comment.setLocalDate(localDate);
        comment.setUser(user);
        return comment;
    }
}
