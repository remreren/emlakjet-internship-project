package com.emlakjet.approval.usecase;

import com.emlakjet.approval.enums.ApprovalStatus;

public record AdvertApprovalUseCase(Long advertId, ApprovalStatus approvalStatus) {
}
