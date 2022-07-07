package com.nttdata.movement.service;

import com.nttdata.movement.integration.account.model.service.AccountService;
import com.nttdata.movement.model.document.Movement;
import com.nttdata.movement.model.repository.MovementRepository;
import com.nttdata.movement.model.service.MovementService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class MovementServiceImpl implements MovementService {
    Logger log = LoggerFactory.getLogger(MovementServiceImpl.class);
    @Autowired
    private MovementRepository movementRepository;
    @Autowired
    private SequenceGeneratorService sequenceGeneratorService;
    @Autowired
    private AccountService accountService;

    @Override
    public Flux<Movement> getAll() {
        return movementRepository.findAll();
    }

    @Override
    public Mono<Movement> save(Movement movement) {
        return accountService.getAccount(movement.getIdAccount()).flatMap(account->{
            if (account.getAmount()<=0){
                return Mono.just(new Movement());
            }
            account.setAmount(account.getAmount()+movement.getAmount());
            log.info("account:"+account);
            accountService.updateAccount(account).subscribe();
            log.info("amount updated:"+account.getAmount());
            movement.setIdMovement(sequenceGeneratorService.getSequenceNumber(Movement.SEQUENCE_NAME));
            return movementRepository.save(movement);
        });
    }

    @Override
    public Mono<Movement> getOne(Long idMovement) {
        return movementRepository.findById(idMovement);
    }

    @Override
    public Mono<Movement> update(Movement movement) {
        return movementRepository.save(movement);
    }


}
