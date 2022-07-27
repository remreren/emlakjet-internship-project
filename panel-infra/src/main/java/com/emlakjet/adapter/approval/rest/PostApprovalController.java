package com.emlakjet.adapter.approval.rest;

import com.emlakjet.adapter.post.PostMapper;
import com.emlakjet.approval.enums.ApprovalStatus;
import com.emlakjet.approval.usecase.PostApprovalUseCase;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.post.dto.PostResponse;
import com.emlakjet.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/post/approval")
public class PostApprovalController {

    private final UseCaseHandler<Post, PostApprovalUseCase> postApprovalUseCaseHandler;

    private final PostMapper mapper;

    @PostMapping("/approve/{postId}")
    public ResponseEntity<PostResponse> approvePost(@PathVariable("postId") Long postId) {

        var post = postApprovalUseCaseHandler.handle(new PostApprovalUseCase(postId, ApprovalStatus.APPROVED));

        return ResponseEntity.ok(mapper.toPostResponse(post));

    }

    @PostMapping("/reject/{postId}")
    public ResponseEntity<PostResponse> rejectPost(@PathVariable("postId") Long postId) {

        var post = postApprovalUseCaseHandler.handle(new PostApprovalUseCase(postId, ApprovalStatus.REJECTED));

        return ResponseEntity.ok(mapper.toPostResponse(post));

    }
}
