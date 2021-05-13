package com.example.demo.Entity;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

@AllArgsConstructor
@Data
@Builder
@EqualsAndHashCode
@ToString
@NoArgsConstructor
@Document(collection = "publications")
public class Publication {

    @Id
    private String id = UUID.randomUUID().toString();
    private String pathPicture;
    private String description;
    private LocalDate date;

    @DBRef
    private Images publicationImage;

    @DBRef
    private User user;

    @DBRef
    private List<Like> likes;

    @DBRef
    private List<Comment> comments;

    public Publication(User user, String pathPicture, String des) {
        this.id = UUID.randomUUID().toString();
        this.user = user;
        this.pathPicture = pathPicture;
        this.description = description;
    }

    public Publication(User user, String des) {
    }

    public static Publication createPublication(String pathPicture, String description, LocalDate date, User user) {
        Publication publication = new Publication();
        publication.setPathPicture(pathPicture);
        publication.setDescription(description);
        publication.setDate(date);
        publication.setUser(user);
        return publication;
    }
}
