package com.socialApp.socialApp.response;

import com.socialApp.socialApp.model.Comment;


public class CommentResponse {
    private Long commentId;
    private String commentString;
    private PostResponse post;
    private String commentedAt;

    public CommentResponse(Comment source) {
        this.commentedAt = source.getCommentedAt ( );
        this.commentId = source.getCommentId ( );
        this.commentString = source.getCommentString ( );
        this.post = new PostResponse ( source.getPost ( ) );
    }

    public String getCommentedAt() {
        return commentedAt;
    }

    public void setCommentedAt(String commentedAt) {
        this.commentedAt = commentedAt;
    }

    public Long getCommentId() {
        return commentId;
    }

    public void setCommentId(Long commentId) {
        this.commentId = commentId;
    }

    public String getCommentString() {
        return commentString;
    }

    public void setCommentString(String commentString) {
        this.commentString = commentString;
    }

    public PostResponse getPost() {
        return post;
    }

    public void setPost(PostResponse post) {
        this.post = post;
    }
}
