package com.socialApp.socialApp.response;

import com.socialApp.socialApp.model.Post;


public class PostResponse {
    private Long postId;
    private String content;
    private String postedAt;
    private UserResponse author;

    public PostResponse(Post source) {
        this.author = new UserResponse ( source.getAuthor ( ) );
        this.content = source.getContent ( );
        this.postedAt = source.getPostedAt ( );
        this.postId = source.getPostId ( );
    }

    public UserResponse getAuthor() {
        return author;
    }

    public void setAuthor(UserResponse author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPostedAt() {
        return postedAt;
    }

    public void setPostedAt(String postedAt) {
        this.postedAt = postedAt;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }
}
