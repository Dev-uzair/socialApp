package com.socialApp.socialApp.model;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.CreationTimestamp;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Getter
@Setter
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long postId;
    private String content;
    @DateTimeFormat
    @CreationTimestamp
    private String postedAt;
    @ManyToOne
    private User author;

}
