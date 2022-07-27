package com.emlakjet.adapter.post;

import com.emlakjet.adapter.post.repo.PostRepository;
import com.emlakjet.post.model.Post;
import com.emlakjet.post.port.PostPort;
import com.emlakjet.post.usecase.CreatePostUseCase;
import com.emlakjet.post.usecase.UpdatePostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component // TODO: Service kullanılmış diğer projelerde
@RequiredArgsConstructor
public class PostAdapter implements PostPort {

    private final PostRepository postRepository;

    private final PostMapper mapper;

    @Override
    public Post createPost(CreatePostUseCase post) {

        var createdPost = postRepository.save(mapper.toPostEntity(post));

        return mapper.toPost(createdPost);
    }

    @Override
    public Post updatePost(UpdatePostUseCase post) {

        var createdPost = postRepository.save(mapper.toPostEntity(post));

        return mapper.toPost(createdPost);
    }

    @Override
    public void deletePost(Long postId) {

        postRepository.deleteById(postId);

    }
}
