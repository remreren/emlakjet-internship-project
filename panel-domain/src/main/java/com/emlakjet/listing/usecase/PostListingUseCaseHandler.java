package com.emlakjet.listing.usecase;

import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.listing.port.PostListingPort;
import com.emlakjet.post.model.Post;
import lombok.RequiredArgsConstructor;

import java.util.List;

import static java.util.Objects.isNull;

@DomainComponent
@RequiredArgsConstructor
public class PostListingUseCaseHandler implements UseCaseHandler<List<Post>, Integer> {

    private static final Integer DEFAULT_SIZE = 30;

    private final PostListingPort postListingPort;

    @Override
    public List<Post> handle(Integer useCase) {

        return postListingPort.getLastNPost(isNull(useCase) ? DEFAULT_SIZE : useCase);

    }
}
