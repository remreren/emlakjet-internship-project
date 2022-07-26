package com.emlakjet.post.port;

import com.emlakjet.post.model.Post;
import com.emlakjet.post.usecase.CreatePostUseCase;
import com.emlakjet.post.usecase.UpdatePostUseCase;

public interface PostPort {

    Post createPost(CreatePostUseCase post);

    Post updatePost(UpdatePostUseCase post);
}
