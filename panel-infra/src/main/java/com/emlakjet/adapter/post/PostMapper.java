package com.emlakjet.adapter.post;

import com.emlakjet.adapter.post.entity.IndoorInfoEntity;
import com.emlakjet.adapter.post.entity.LocationPointEntity;
import com.emlakjet.adapter.post.entity.PostEntity;
import com.emlakjet.adapter.post.rest.dto.PostRequest;
import com.emlakjet.post.dto.PostResponse;
import com.emlakjet.post.model.IndoorInfo;
import com.emlakjet.post.model.LocationPoint;
import com.emlakjet.post.model.Post;
import com.emlakjet.post.usecase.CreatePostUseCase;
import com.emlakjet.post.usecase.UpdatePostUseCase;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface PostMapper {

    Post toPost(PostEntity post);

    PostEntity toPostEntity(Post post);

    PostEntity toPostEntity(CreatePostUseCase useCase);

    PostEntity toPostEntity(UpdatePostUseCase useCase);

    LocationPoint toLocation(LocationPointEntity locationPoint);

    LocationPointEntity toLocationEntity(LocationPoint locationPoint);

    IndoorInfo toIndoorInfo(IndoorInfoEntity indoorInfo);

    IndoorInfoEntity toIndoorInfoEntity(IndoorInfo indoorInfo);

    UpdatePostUseCase toUpdatePostUseCase(PostRequest post);

    UpdatePostUseCase toUpdatePostUseCase(PostEntity post);

    CreatePostUseCase toCreatePostUseCase(PostRequest post);

    PostResponse toPostResponse(Post post);
}
