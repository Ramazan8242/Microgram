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
@Document(collection = "subscriptions")
public class Subscription {

    @Id
    private String id = UUID.randomUUID().toString();

    @DBRef
    private User user;

    @DBRef
    private User toUser;

    private LocalDate date;

    public static Subscription createSubscription(User user, User toUser, LocalDate localDate) {
        Subscription subscription = new Subscription();
        subscription.setUser(user);
        subscription.setToUser(toUser);
        subscription.setDate(localDate);
        return subscription;
    }
}
