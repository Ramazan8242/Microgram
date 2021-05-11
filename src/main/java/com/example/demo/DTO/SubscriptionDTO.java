package com.example.demo.DTO;

import com.example.demo.Entity.Subscription;
import com.example.demo.Entity.User;
import lombok.*;

import java.time.LocalDate;

@Data
@Builder(access = AccessLevel.PRIVATE)
@AllArgsConstructor(access = AccessLevel.PRIVATE)
@NoArgsConstructor(access = AccessLevel.PRIVATE, force = true)
public class SubscriptionDTO {
    private User user;
    private User toUser;
    private LocalDate date;

    public static SubscriptionDTO from(Subscription subscription) {
        return builder()
                .user(subscription.getUser())
                .toUser(subscription.getToUser())
                .date(subscription.getDate())
                .build();
    }
}
