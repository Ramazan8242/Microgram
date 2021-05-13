package com.example.demo.DTO;

import com.example.demo.Entity.User;
import lombok.*;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class UserDTO {
    private String name;
    private String username;
    private String email;
    private String password;
    private Integer countOfPosts;
    private Integer countOfFollowers;
    private Integer countOfSubs;

    public static UserDTO from(User user) {
        return builder()
                .name(user.getName())
                .username(user.getUsername())
                .email(user.getEmail())
                .password(user.getPassword())
                .build();
    }
}
