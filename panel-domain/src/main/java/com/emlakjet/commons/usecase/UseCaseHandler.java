package com.emlakjet.commons.usecase;

public interface UseCaseHandler<T, V> {

    T handle(V useCase);
}
