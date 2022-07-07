package com.nttdata.movement.api;


import com.nttdata.movement.model.document.Movement;
import com.nttdata.movement.model.service.MovementService;
import com.nttdata.movement.service.SequenceGeneratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("api/movement")
public class MovementsController {
    @Autowired
    private MovementService movementService;

    @Autowired
    private SequenceGeneratorService sequenceService;

    @PostMapping
    public Mono<Movement> save(@RequestBody Movement movement){
        return movementService.save(movement);
    }
    @PutMapping
    public Mono<Movement> update(@RequestBody Movement movement){
        return movementService.update(movement);
    }
    @GetMapping
    public Flux<Movement> getAll(){
        return movementService.getAll();
    }
    @GetMapping("/{idMovement}")
    public Mono<Movement> getOne(@PathVariable Long idMovement){
        return movementService.getOne(idMovement);
    }

}