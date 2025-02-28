package com.socialApp.socialApp.serviceImpl;

import com.socialApp.socialApp.model.Post;
import com.socialApp.socialApp.repository.PostRepository;
import com.socialApp.socialApp.repository.UserRepository;
import com.socialApp.socialApp.request.PostRequest;
import com.socialApp.socialApp.response.PostResponse;
import com.socialApp.socialApp.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    private PostRepository repository;
    private UserRepository userRepository;

    @Autowired
    public PostServiceImpl(PostRepository repository, UserRepository userRepository) {
        this.repository = repository;
        this.userRepository = userRepository;
    }

    @Override
    public void createPost(PostRequest request) {
        Post entity = new Post ( );
        entity.setAuthor ( userRepository.findById ( request.getAuthorId ( ) )
                .orElseThrow ( () -> new RuntimeException ( "Id Not found" ) ) );
        entity.setContent ( request.getContent ( ) );
        repository.save ( entity );
    }

    @Override
    public PostResponse findPostByPostId(Long postId) {
        return new PostResponse (
                repository.findById ( postId )
                        .orElseThrow ( () ->
                                new RuntimeException ( "Id not found" ) ) );
    }

    @Override
    public List<PostResponse> findAllPost() {
        List<Post> all = repository.findAll ( );
        return all.stream ( ).map ( PostResponse::new ).toList ( );
    }

    @Override
    public PostResponse updatePostByPostId(Long postId, PostRequest request) {

        Post entity = repository.findById ( postId )
                .orElseThrow ( () -> new RuntimeException ( "user not found" ) );
        if ( request.getContent ( ) != null )
            entity.setContent ( request.getContent ( ) );

        if ( request.getAuthorId ( ) != null ) {
            entity.setAuthor ( userRepository.findById ( request.getAuthorId ( ) )
                    .orElseThrow ( () -> new RuntimeException ( "Id Not found" ) ) );
        }

        return new PostResponse ( entity );
    }

    @Override
    public void deletePostByPostId(Long postId) {
        Post post = repository.findById ( postId ).orElseThrow ( () -> new RuntimeException ( "Id not found" ) );
        repository.delete ( post );
    }
}
