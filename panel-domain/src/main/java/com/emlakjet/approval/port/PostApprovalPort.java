package com.emlakjet.approval.port;

import com.emlakjet.approval.usecase.PostApprovalUseCase;
import com.emlakjet.post.model.Post;

public interface PostApprovalPort {

    Post updateApprovalStatus(PostApprovalUseCase useCase);
}
