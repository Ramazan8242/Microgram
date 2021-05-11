package com.example.demo.Controller;

import com.example.demo.DTO.SubscriptionDTO;
import com.example.demo.Entity.Subscription;
import com.example.demo.Entity.User;
import com.example.demo.Service.SubscriptionService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@AllArgsConstructor
@RequestMapping("/subscription")
public class SubscriptionController {
    private final SubscriptionService subscriptionService;

    @PostMapping("/{id}")
    public SubscriptionDTO addSubs(@PathVariable String id, Authentication authentication) throws Exception {
        User user = (User) authentication.getPrincipal();
        return subscriptionService.addSubscription(user.getId(), id);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteSubs(@PathVariable String id, Authentication authentication) throws Exception {
        User user = (User) authentication.getPrincipal();
        Subscription subscription = subscriptionService.findById(id);

        if (subscription.getUser().getId().equals(user.getId())) {
            if (subscriptionService.deleteSubscription(id)) {
                return ResponseEntity.noContent().build();
            }
        }
        return ResponseEntity.notFound().build();
    }
}
