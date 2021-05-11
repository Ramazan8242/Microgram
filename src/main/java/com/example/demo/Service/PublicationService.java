package com.example.demo.Service;

import com.example.demo.DTO.PublicationDTO;
import com.example.demo.Entity.Publication;
import com.example.demo.Entity.Subscription;
import com.example.demo.Entity.User;
import com.example.demo.Repository.*;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class PublicationService {
    private final PublicationRepository publicationRepository;
    private final SubscriptionRepository subscriptionRepository;
    private final UserRepository userRepository;
    private final LikeRepository likeRepository;
    private final CommentRepository commentRepository;

    public List<Publication> findAllMySubPosts(String id) {
        List<Subscription> allByUserId = subscriptionRepository.findAllPublicationByUserId(id);
        List<Publication> posts = new ArrayList<>();
        for (Subscription s :
                allByUserId) {
            List<Publication> publicationByUser = publicationRepository.findAllPublicationByUserId(s.getToUser().getId());
            posts.addAll(publicationByUser);
        }
        return posts;
    }

    public Publication findById(String id) throws Exception {
        return publicationRepository.findById(id).orElseThrow(() -> new Exception("There is no such publication"));
    }

    public List<PublicationDTO> publicationService(String id) throws Exception {
        User user = userRepository.findById(id)
                .orElseThrow(() -> new Exception("There is no such a user with " + id + " id"));
        List<Publication> allPublicationByUserId = publicationRepository.findAllPublicationByUserId(id);
        List<PublicationDTO> posts = new ArrayList<>();
        for (Publication publication : allPublicationByUserId) {
            posts.add(PublicationDTO.from(publication));
        }
        return posts;
    }

    public void save(Publication publication) {
        publicationRepository.save(publication);
    }

    public boolean deletePost(String publicationId) {
        Publication publicationById = (Publication) publicationRepository.findPublicationById(publicationId);
        commentRepository.deleteCommentsByPublicationId(publicationId);
        publicationRepository.deleteById(publicationId);
        return true;
    }
}
