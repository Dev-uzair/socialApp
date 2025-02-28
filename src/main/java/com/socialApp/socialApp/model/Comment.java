package com.socialApp.socialApp.model;

import jakarta.persistence.*;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long commentId;
    private String commentString;
    @ManyToOne
    private Post post;
    @ManyToOne
    private User author;
    @DateTimeFormat
    @CreationTimestamp
    private String commentedAt;

    public User getAuthor() {
        return author;
    }

    public void setAuthor(User author) {
        this.author = author;
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

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }
}
