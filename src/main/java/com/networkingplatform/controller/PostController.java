package com.networkingplatform.controller;

import com.networkingplatform.model.Post;
import com.networkingplatform.service.PostService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/posts")
public class PostController {

    private final PostService postService;

    public PostController(PostService postService) {
        this.postService = postService;
    }

    @PostMapping("/create")
    public String createPost(@RequestBody Post post, @RequestParam String username, @RequestParam String password) {
        return postService.createPost(post, username, password);
    }

    @GetMapping("/")
    public List<Post> getAllPosts() {
        return postService.getAllPosts();
    }

    @GetMapping("/user/{username}")
    public List<Post> getPostsByUser(@PathVariable String username) {
        return postService.getPostsByUser(username);
    }
}


