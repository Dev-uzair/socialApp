package com.socialApp.socialApp.serviceImpl;

import com.socialApp.socialApp.model.Comment;
import com.socialApp.socialApp.model.Post;
import com.socialApp.socialApp.repository.CommentRepository;
import com.socialApp.socialApp.repository.PostRepository;
import com.socialApp.socialApp.request.CommentRequest;
import com.socialApp.socialApp.response.CommentResponse;
import com.socialApp.socialApp.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    private CommentRepository repository;
    private PostRepository postRepository;

    @Autowired
    public CommentServiceImpl(PostRepository postRepository, CommentRepository repository) {
        this.postRepository = postRepository;
        this.repository = repository;
    }

    @Override
    public void createComment(CommentRequest request) {
        Comment entity = new Comment ( );
        entity.setCommentString ( request.getCommentString ( ) );
        Post post = postRepository.findById ( request.getPostId ( ) ).orElseThrow ( () -> new RuntimeException ( "post not found" ) );
        entity.setPost ( post );
        entity.setAuthor ( post.getAuthor ( ) );
        repository.save ( entity );

    }

    @Override
    public CommentResponse findCommentByCommentId(Long commentId) {
        return new CommentResponse (
                repository.findById ( commentId )
                        .orElseThrow ( () ->
                                new RuntimeException ( "comment not found" ) ) );

    }

    @Override
    public List<CommentResponse> findAllComment() {
        List<Comment> all = repository.findAll ( );
        return all.stream ( ).map ( CommentResponse::new ).toList ( );
    }

    @Override
    public CommentResponse updateCommentByCommentId(Long commentId, CommentRequest request) {
        Comment comment = repository.findById ( commentId )
                .orElseThrow ( () -> new RuntimeException ( "user not found" ) );

        if ( request.getCommentString ( ) != null )
            comment.setCommentString ( request.getCommentString ( ) );

        if ( request.getPostId ( ) != null ) {
            Post post = postRepository.findById ( request.getPostId ( ) ).orElseThrow ( () -> new RuntimeException ( "post not found" ) );
            comment.setPost ( post );
            comment.setAuthor ( post.getAuthor ( ) );
        }
        Comment save = repository.save ( comment );

        return new CommentResponse ( save );
    }

    @Override
    public void deleteCommentByCommentId(Long commentId) {
        Comment comment = repository.findById ( commentId ).orElseThrow ( () -> new RuntimeException ( "Id not found" ) );
        repository.delete ( comment );
    }
}
