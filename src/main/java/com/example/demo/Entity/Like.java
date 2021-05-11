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
@Document(collection = "likes")
public class Like {

    @Id
    private String id = UUID.randomUUID().toString();

    @DBRef
    private User user;

    @DBRef
    private Publication publication;

    private LocalDate localDate;

    public static Like createLike(User user, Publication publication, LocalDate localDate) {
        Like like = new Like();
        like.setUser(user);
        like.setPublication(publication);
        like.setLocalDate(localDate);
        return like;
    }
}
