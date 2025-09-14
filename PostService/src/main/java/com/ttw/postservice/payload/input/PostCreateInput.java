package com.ttw.postservice.payload.input;

import com.ttw.postservice.model.Post;

import java.time.LocalDateTime;
import java.util.UUID;

public record PostCreateInput(
        String content,
        UUID authorId,
        String visibility
        
) {
    public  static Post model(PostCreateInput input) {
        Post post = new Post();
        post.setContent(input.content);
        post.setAuthorUUID(input.authorId);
        post.setVisibility(Post.Visibility.valueOf(input.visibility));
        post.setCreatedAt(LocalDateTime.now());
        return post;
    }

}
