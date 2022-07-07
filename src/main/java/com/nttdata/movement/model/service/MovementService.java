package com.nttdata.movement.model.service;

import com.nttdata.movement.model.document.Movement;
import com.nttdata.movement.integration.account.model.entity.Account;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public interface MovementService {
    Flux<Movement> getAll();
    Mono<Movement> save(Movement movement);
    Mono<Movement> getOne(Long idMovement);
    Mono<Movement> update(Movement movement);
}
