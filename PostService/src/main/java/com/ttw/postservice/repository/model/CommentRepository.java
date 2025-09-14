package com.ttw.postservice.repository.model;

import com.ttw.postservice.model.Comment;
import com.ttw.postservice.repository.BaseRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CommentRepository  extends BaseRepository<Comment, Long> {
    @Query("select c from Comment c where c.post.postId =: postId")
    List<Comment> getCommentsByPostId(@Param("postId") long postId);

}
