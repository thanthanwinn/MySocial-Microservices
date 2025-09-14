package com.ttw.postservice.service.impl;

import com.ttw.postservice.model.Comment;
import com.ttw.postservice.model.Post;
import com.ttw.postservice.payload.input.CommentCreateInput;
import com.ttw.postservice.payload.output.CommentInfoOutput;
import com.ttw.postservice.repository.model.CommentRepository;
import com.ttw.postservice.repository.model.PostRepository;
import com.ttw.postservice.service.CommentService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {

    private final CommentRepository commentRepository;
    private final PostRepository postRepository;

    @Override
    public void addComment(CommentCreateInput input) {
        Post post = postRepository.findById(input.postId()).orElseThrow();
        Comment comment = CommentCreateInput.model(input,post);
        commentRepository.save(comment);
    }

    @Override
    public void deleteComment(long id) {
        commentRepository.deleteById(id);
    }

    @Override
    public List<CommentInfoOutput> getCommentsByPostId(long postId) {
      List<Comment>  comments =  commentRepository.getCommentsByPostId(postId);
      List<CommentInfoOutput> outputs = comments.stream()
              .map(c -> CommentInfoOutput.from(c))
              .collect(Collectors.toList());
      return outputs;
    }
}
