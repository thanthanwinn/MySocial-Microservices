package com.ttw.postservice.service;

import com.ttw.postservice.model.Comment;
import com.ttw.postservice.payload.input.CommentCreateInput;
import com.ttw.postservice.payload.output.CommentInfoOutput;

import java.util.List;

public interface CommentService {
    void addComment(CommentCreateInput input);
    void deleteComment(long id);
    List<CommentInfoOutput> getCommentsByPostId(long postId);
}
