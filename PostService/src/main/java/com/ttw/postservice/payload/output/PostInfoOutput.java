package com.ttw.postservice.payload.output;

import com.ttw.postservice.model.Comment;
import com.ttw.postservice.model.Post;

import java.util.List;
import java.util.UUID;

public record PostInfoOutput(
        Long postId,
        String content,
        UUID authorId,
        String visibility,
        String createdAt,
        List<CommentInfoOutput> comments
) {
    public static PostInfoOutput of(Post post, List<CommentInfoOutput> comment) {
        return new PostInfoOutput(
                post.getPostId(),
                post.getContent(),
                post.getAuthorUUID(),
                post.getVisibility().toString(),
                post.getCreatedAt().toString(),
                comment
        );
    }

}
