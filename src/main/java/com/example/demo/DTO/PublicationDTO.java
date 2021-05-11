package com.example.demo.DTO;

import com.example.demo.Entity.Comment;
import com.example.demo.Entity.Like;
import com.example.demo.Entity.Publication;
import com.example.demo.Entity.User;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class PublicationDTO {
    private String pathPicture;
    private String description;
    private LocalDate date;
    private User user;
    private List<Like> likes;
    private List<Comment> comments;

    public static PublicationDTO from(Publication publication) {
        return builder()
                .pathPicture(publication.getPathPicture())
                .description(publication.getDescription())
                .date(publication.getDate())
                .user(publication.getUser())
                .comments(publication.getComments())
                .likes(publication.getLikes())
                .build();
    }
}
