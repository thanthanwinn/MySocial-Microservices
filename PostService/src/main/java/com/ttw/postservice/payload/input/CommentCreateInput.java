package com.ttw.postservice.payload.input;

import com.ttw.postservice.model.Comment;
import com.ttw.postservice.model.Post;

import java.time.LocalDateTime;
import java.util.UUID;

public record CommentCreateInput(
        String content,
        Long postId,
        UUID authorId
) {
    public static Comment model(CommentCreateInput input, Post post) {
        Comment comment = new Comment();
        comment.setContent(input.content);
        comment.setPost(post);
        comment.setCreatedAt(LocalDateTime.now());
        comment.setAuthorId(input.authorId);
        return comment;
    }
}
