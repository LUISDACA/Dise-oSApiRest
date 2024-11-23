package com.networkingplatform.repository;

import com.networkingplatform.model.Post;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PostRepository extends MongoRepository<Post, String> {
    List<Post> findByUsername(String username);
}
