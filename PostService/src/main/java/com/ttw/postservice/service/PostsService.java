package com.ttw.postservice.service;

import com.ttw.postservice.model.Post;
import com.ttw.postservice.payload.input.PostCreateInput;

public interface PostsService {

    void createPost(PostCreateInput input);

}
