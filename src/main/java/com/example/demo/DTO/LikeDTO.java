package com.example.demo.DTO;

import com.example.demo.Entity.Like;
import com.example.demo.Entity.Publication;
import com.example.demo.Entity.User;
import lombok.*;
import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class LikeDTO {
    private User user;
    private Publication publication;
    private LocalDate date;

    public static LikeDTO from(Like like) {
        return builder()
                .date(like.getLocalDate())
                .publication(like.getPublication())
                .user(like.getUser())
                .build();
    }
}
