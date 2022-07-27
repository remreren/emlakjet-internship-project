package com.emlakjet.approval.usecase;

import com.emlakjet.approval.enums.ApprovalStatus;

public record PostApprovalUseCase(Long postId, ApprovalStatus approvalStatus) {
}
