package com.socialApp.socialApp.service;

import com.socialApp.socialApp.request.PostRequest;
import com.socialApp.socialApp.response.PostResponse;

import java.util.List;

public interface PostService {
    public void createPost(PostRequest request);

    public PostResponse findPostByPostId(Long postId);

    public List<PostResponse> findAllPost();

    public PostResponse updatePostByPostId(Long postId, PostRequest request);

    public void deletePostByPostId(Long postId);

}
