package com.example.demo.Controller;

import com.example.demo.DTO.LikeDTO;
import com.example.demo.Entity.Like;
import com.example.demo.Entity.User;
import com.example.demo.Service.LikeService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/likes")
@AllArgsConstructor
public class LikeController {
    private final LikeService likeService;

    @PostMapping("/{publicationId}")
    public LikeDTO addLike(@PathVariable String publicationId, Authentication authentication) throws Exception {
        User user = (User) authentication.getPrincipal();
        return likeService.addLike(publicationId, user.getId());
    }

    @DeleteMapping("/delete/{likeId}")
    public ResponseEntity<Void> deleteLike(@PathVariable String likeId, Authentication authentication) throws Exception {
        User user = (User) authentication.getPrincipal();
        Like like = likeService.findById(likeId);
        if (like.getUser().getId().equals(user.getId())) {
            if (likeService.deleteLike(likeId))
                return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
