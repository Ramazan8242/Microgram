package com.example.demo.Repository;

import com.example.demo.Entity.Like;
import com.example.demo.Entity.Publication;
import com.example.demo.Entity.User;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LikeRepository extends MongoRepository<Like, String> {
}
