package com.emlakjet.advert.exception;

import com.emlakjet.approval.enums.ApprovalStatus;

public class AdvertApprovalStatusException extends RuntimeException {

    public AdvertApprovalStatusException(ApprovalStatus status) {
        this("The status of the advert is %s so you cannot make any changes on this state.".formatted(status));
    }

    public AdvertApprovalStatusException(String message) {
        super(message);
    }
}
