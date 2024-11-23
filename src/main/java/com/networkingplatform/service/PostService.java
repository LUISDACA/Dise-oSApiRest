package com.networkingplatform.service;

import com.networkingplatform.model.Post;
import com.networkingplatform.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostService {

    private final PostRepository postRepository;
    private final UserService userService;

    public PostService(PostRepository postRepository, UserService userService) {
        this.postRepository = postRepository;
        this.userService = userService;
    }

    public String createPost(Post post, String username, String password) {
        if (!userService.authenticate(username, password)) {
            return "Invalid credentials!";
        }
        if (!username.equals(post.getUsername())) {
            return "The post's username must match the logged-in user!";
        }
        postRepository.save(post);
        return "Post created successfully!";
    }

    public List<Post> getAllPosts() {
        return postRepository.findAll();
    }

    public List<Post> getPostsByUser(String username) {
        return postRepository.findByUsername(username);
    }
}
