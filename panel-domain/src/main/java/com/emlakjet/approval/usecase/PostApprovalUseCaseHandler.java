package com.emlakjet.approval.usecase;

import com.emlakjet.approval.port.PostApprovalPort;
import com.emlakjet.commons.DomainComponent;
import com.emlakjet.commons.usecase.UseCaseHandler;
import com.emlakjet.post.model.Post;
import lombok.RequiredArgsConstructor;

@DomainComponent
@RequiredArgsConstructor
public class PostApprovalUseCaseHandler implements UseCaseHandler<Post, PostApprovalUseCase> {

    private final PostApprovalPort postApprovalPort;

    @Override
    public Post handle(PostApprovalUseCase useCase) {

        return postApprovalPort.updateApprovalStatus(useCase);

    }
}
