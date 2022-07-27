package com.emlakjet.adapter.listing.rest;

import com.emlakjet.adapter.post.PostMapper;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.listing.usecase.PagingUseCase;
import com.emlakjet.post.dto.PostResponse;
import com.emlakjet.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/post/list")
public class ListPostController {

    private final UseCaseHandler<List<Post>, PagingUseCase> postListingUseCaseHandler;

    private final PostMapper mapper;

    @GetMapping(value = {"", "/{page}"})
    public List<PostResponse> getPosts(
            @PathVariable(value = "page", required = false) Integer page,
            @RequestParam(value = "pageSize", required = false, defaultValue = "30") Integer pageSize) {

        return postListingUseCaseHandler.handle(new PagingUseCase(page, pageSize)).parallelStream().map(mapper::toPostResponse).toList();

    }
}
