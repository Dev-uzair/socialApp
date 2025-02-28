package com.socialApp.socialApp.controller;

import com.socialApp.socialApp.request.CommentRequest;
import com.socialApp.socialApp.response.CommentResponse;
import com.socialApp.socialApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/comments")
public class CommentController {
    @Autowired
    private CommentService service;

    //create
    @PostMapping("/")
    public void createComment(@RequestBody CommentRequest request) {
        service.createComment ( request );
    }

    //read
    @GetMapping("/{commentId}")
    public CommentResponse findByCommentId(@PathVariable Long commentId) {
        return service.findCommentByCommentId ( commentId );

    }

    //readAll
    @GetMapping("/")
    public List<CommentResponse> getAllComments() {
        return service.findAllComment ( );
    }

    //update
    @PutMapping("/{commentId}")
    public CommentResponse updateComment(@PathVariable Long commentId, @RequestBody CommentRequest request) {
        return service.updateCommentByCommentId ( commentId, request );


    }
    //delete

    @DeleteMapping("/{commentId}")
    public void deleteComment(@PathVariable Long commentId) {
        service.deleteCommentByCommentId ( commentId );
    }
}
