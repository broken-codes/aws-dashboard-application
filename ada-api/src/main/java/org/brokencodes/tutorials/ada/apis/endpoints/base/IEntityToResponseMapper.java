package org.brokencodes.tutorials.ada.apis.endpoints.base;

import reactor.core.publisher.Mono;

public interface IEntityToResponseMapper<E, R> {

    Mono<R> mapEntityToResponse(Mono<E> entity);

}
