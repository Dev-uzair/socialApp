package com.socialApp.socialApp.controller;

import com.socialApp.socialApp.request.PostRequest;
import com.socialApp.socialApp.response.PostResponse;
import com.socialApp.socialApp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/posts")
public class PostController {
    @Autowired
    private PostService service;

    //create
    @PostMapping("/")
    public void createPost(@RequestBody PostRequest request) {
        service.createPost ( request );
    }

    //read
    @GetMapping("/{postId}")
    public PostResponse findByPostId(@PathVariable Long postId) {
        return service.findPostByPostId ( postId );

    }

    //readAll
    @GetMapping("/")
    public List<PostResponse> getAllPosts() {
        return service.findAllPost ( );
    }

    //update
    @PutMapping("/{postId}")
    public PostResponse updatePost(@PathVariable Long postId, @RequestBody PostRequest request) {
        return service.updatePostByPostId ( postId, request );


    }
    //delete

    @DeleteMapping("/{postId}")
    public void deletePost(@PathVariable Long postId) {
        service.deletePostByPostId ( postId );
    }
}
