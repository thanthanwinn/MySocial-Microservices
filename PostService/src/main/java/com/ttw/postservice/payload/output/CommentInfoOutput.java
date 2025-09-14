package com.ttw.postservice.payload.output;

import com.ttw.postservice.model.Comment;

import java.util.UUID;

public record CommentInfoOutput(
        Long commentId,
        String content,
        String createdAt,
        UUID authorId,
        Long postId
) {
    public static CommentInfoOutput from(Comment comment) {
        return new CommentInfoOutput(
                comment.getCommentId(),
                comment.getContent(),
                comment.getCreatedAt().toString(),
                comment.getAuthorId(),
                comment.getPost().getPostId()
        );
    }

}
