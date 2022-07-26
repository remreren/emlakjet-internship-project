package com.emlakjet.adapter.listing.rest;

import com.emlakjet.adapter.post.PostMapper;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.post.dto.PostResponse;
import com.emlakjet.post.model.Post;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.Max;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1/post/list")
public class ListPostController {

    private final UseCaseHandler<List<Post>, Integer> postListingUseCaseHandler;

    private final PostMapper mapper;

    @GetMapping(value = {"/", "/{count}/"})
    public List<PostResponse> getPosts(@PathVariable(value = "count", required = false) @Max(30) Integer count) {

        return postListingUseCaseHandler.handle(count).parallelStream().map(mapper::toPostResponse).toList();

    }
}
