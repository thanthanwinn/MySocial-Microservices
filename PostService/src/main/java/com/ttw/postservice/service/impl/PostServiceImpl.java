package com.ttw.postservice.service.impl;

import com.ttw.postservice.model.Post;
import com.ttw.postservice.payload.input.PostCreateInput;
import com.ttw.postservice.repository.model.PostRepository;
import com.ttw.postservice.service.PostsService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PostServiceImpl implements PostsService {

    private final PostRepository postRepository;

    @Override
    public void createPost(PostCreateInput input) {
        Post post = PostCreateInput.model(input);
        postRepository.save(post);
    }

}
