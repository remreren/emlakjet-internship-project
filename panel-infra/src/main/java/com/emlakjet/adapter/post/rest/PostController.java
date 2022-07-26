package com.emlakjet.adapter.post.rest;

import com.emlakjet.adapter.post.rest.dto.PostRequest;
import com.emlakjet.post.dto.PostResponse;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.post.model.Post;
import com.emlakjet.post.usecase.CreatePostUseCase;
import com.emlakjet.post.usecase.UpdatePostUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/post")
public class PostController {

    private final UseCaseHandler<Post, CreatePostUseCase> createPostUseCaseHandler;

    private final UseCaseHandler<Post, UpdatePostUseCase> updatePostUseCaseHandler;

    @PutMapping("/")
    public ResponseEntity<PostResponse> createPost(@RequestBody PostRequest post) {

        var createdResponse = createPostUseCaseHandler.handle(post.toUseCase());

        return ResponseEntity.ok(PostResponse.from(createdResponse));

    }

    @PostMapping("/{postId}")
    public ResponseEntity<PostResponse> updatePost(@RequestBody PostRequest post, @PathVariable("postId") Long postId) {

        var updateResponse = updatePostUseCaseHandler.handle(post.toUseCase(postId));

        return ResponseEntity.ok(PostResponse.from(updateResponse));

    }
}
