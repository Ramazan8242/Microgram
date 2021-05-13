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

    public List<PublicationDTO> publicationService(String id){
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
        publicationRepository.deleteById(publicationId);
        return true;
    }
}
