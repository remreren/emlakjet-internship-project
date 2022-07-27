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
public class PagingPostListUseCaseHandler implements UseCaseHandler<List<Post>, PagingUseCase> {

    private static final Integer DEFAULT_PAGE_SIZE = 30;

    private static final Integer DEFAULT_PAGE = 0;

    private final PostListingPort postListingPort;

    @Override
    public List<Post> handle(PagingUseCase useCase) {

        var page = isNull(useCase.page()) ? DEFAULT_PAGE : useCase.page();

        return postListingPort.getPostsPaging(useCase.toBuilder().page(page).build());

    }
}
