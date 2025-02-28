package com.socialApp.socialApp.service;

import com.socialApp.socialApp.request.CommentRequest;
import com.socialApp.socialApp.response.CommentResponse;

import java.util.List;

public interface CommentService {
    public void createComment(CommentRequest request);

    public CommentResponse findCommentByCommentId(Long commentId);

    public List<CommentResponse> findAllComment();

    public CommentResponse updateCommentByCommentId(Long commentId, CommentRequest request);

    public void deleteCommentByCommentId(Long commentId);

}
