package com.example.demo.Service;

import com.example.demo.DTO.SubscriptionDTO;
import com.example.demo.Entity.Subscription;
import com.example.demo.Entity.User;
import com.example.demo.Repository.SubscriptionRepository;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class SubscriptionService {
    private final UserRepository userRepository;
    private final SubscriptionRepository subscriptionRepository;

    public SubscriptionDTO addSubscription(String userId, String toUserId) throws Exception {
        User user = userRepository.findById(userId).orElseThrow(() -> new Exception("There is no such a user with " + userId + " id"));
        User toUser = userRepository.findById(toUserId).orElseThrow(() -> new Exception("There is no such a user with " + userId + " id"));
        return SubscriptionDTO.from(subscriptionRepository.save(Subscription.createSubscription(user, toUser, LocalDate.now())));
    }

    public boolean deleteSubscription(String subscriptionId) {
        subscriptionRepository.deleteById(subscriptionId);
        return true;
    }

    public Subscription findById(String id) throws Exception {
        return subscriptionRepository.findById(id).orElseThrow(() ->
                new Exception("There is not suck subs"));
    }
}
