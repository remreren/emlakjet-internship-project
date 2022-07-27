package com.emlakjet.adapter.listing;

import com.emlakjet.adapter.post.PostMapper;
import com.emlakjet.adapter.post.repo.PostRepository;
import com.emlakjet.listing.usecase.PagingUseCase;
import com.emlakjet.listing.port.PostListingPort;
import com.emlakjet.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import java.util.List;

@Component // TODO: Service kullanılmış diğer projelerde
@RequiredArgsConstructor
public class PostListingAdapter implements PostListingPort {

    private final PostRepository postRepository;

    private final PostMapper mapper;

    @Override
    public List<Post> getPostsPaging(PagingUseCase pagingUseCase) {

        var pageable = Pageable.ofSize(pagingUseCase.pageSize())
                .withPage(pagingUseCase.page());

        return postRepository.findAll(pageable).map(mapper::toPost).toList();
    }
}
