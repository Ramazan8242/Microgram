package com.example.demo.Repository;

import com.example.demo.Entity.Publication;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PublicationRepository extends MongoRepository<Publication, String> {
    List<Publication> findPublicationById(String publicationId);
    List<Publication> findAllPublicationByUserId(String id);
}
