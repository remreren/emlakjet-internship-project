package com.emlakjet.post.usecase;

import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.post.model.Post;
import com.emlakjet.post.port.PostPort;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class CreatePostUseCaseHandler implements UseCaseHandler<Post, CreatePostUseCase> {

    private final PostPort postPort;

    @Override
    public Post handle(CreatePostUseCase useCase) {

        return postPort.createPost(useCase);

    }
}
