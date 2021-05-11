package com.example.demo.Repository;

import com.example.demo.Entity.Images;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImagesRepository extends MongoRepository<Images, String> {
}
