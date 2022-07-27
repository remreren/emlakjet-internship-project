package com.emlakjet.post.usecase;

import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.commons.usecase.VoidUseCaseHandler;
import com.emlakjet.post.port.PostPort;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class DeletePostUseCaseHandler implements VoidUseCaseHandler<Long> {

    private final PostPort postPort;

    @Override
    public void handle(Long useCase) {

        postPort.deletePost(useCase);

    }
}
