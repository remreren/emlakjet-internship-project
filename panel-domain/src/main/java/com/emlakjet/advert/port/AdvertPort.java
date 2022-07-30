package com.emlakjet.advert.port;

import com.emlakjet.advert.model.Advert;
import com.emlakjet.advert.usecase.CreateAdvertUseCase;
import com.emlakjet.advert.usecase.UpdateAdvertUseCase;

public interface AdvertPort {

    Advert createPost(CreateAdvertUseCase post);

    Advert updatePost(UpdateAdvertUseCase post);

    void deletePost(Long postId);
}
