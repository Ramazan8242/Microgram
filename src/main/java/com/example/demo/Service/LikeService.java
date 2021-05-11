package com.example.demo.Service;

import com.example.demo.DTO.LikeDTO;
import com.example.demo.Entity.Like;
import com.example.demo.Entity.Publication;
import com.example.demo.Entity.User;
import com.example.demo.Repository.LikeRepository;
import com.example.demo.Repository.PublicationRepository;
import com.example.demo.Repository.UserRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
@AllArgsConstructor
public class LikeService {
    private final UserRepository userRepository;
    private final PublicationRepository publicationRepository;
    private final LikeRepository likeRepository;

    public boolean existsThereAnyLikeByUserAndPost(String publicationId, String id) {
        User userById = userRepository.findUserById(id);
        Publication publicationsId = (Publication) publicationRepository.findPublicationById(publicationId);
        return likeRepository.existsLikeByUserAndPublication(userById, publicationsId);
    }

    public LikeDTO addLike(String publicationId, String userId) throws Exception {

        Publication publication = publicationRepository.findById(publicationId)
                .orElseThrow(() -> new Exception("There is not such a post with " + publicationId + "id"));
        User user = userRepository.findById(userId)
                .orElseThrow(() -> new Exception("There is no such a user with " + userId + " id"));

        return LikeDTO.from(Like.createLike(user, publication, LocalDate.now()));
    }

    public boolean deleteLike(String likeId) {
        likeRepository.deleteById(likeId);
        return true;
    }

    public Like findById(String id) throws Exception {
        return likeRepository.findById(id).orElseThrow(()->
                new Exception("There is not suck like"));
    }
}
