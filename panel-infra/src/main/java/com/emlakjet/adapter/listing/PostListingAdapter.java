package com.emlakjet.adapter.listing;

import com.emlakjet.adapter.post.entity.PostEntity;
import com.emlakjet.adapter.post.repo.PostRepository;
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

    @Override
    public List<Post> getLastNPost(Integer n) {

        return postRepository.findAll(Pageable.ofSize(n).first()).map(PostEntity::toPost).toList();

    }
}
