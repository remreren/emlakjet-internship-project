package com.emlakjet.publishing.exception;

public class AdvertStatusException extends RuntimeException {

    public AdvertStatusException() {
        super("You cannot update your advert when published. Please unpublish your advert to update.");
    }

    public AdvertStatusException(String message) {
        super(message);
    }
}
