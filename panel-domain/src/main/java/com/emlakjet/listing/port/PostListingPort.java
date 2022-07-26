package com.emlakjet.listing.port;

import com.emlakjet.post.model.Post;

import java.util.List;

public interface PostListingPort {

    List<Post> getLastNPost(Integer n);
}
