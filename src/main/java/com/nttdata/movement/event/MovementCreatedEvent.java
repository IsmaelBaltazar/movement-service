package com.nttdata.movement.event;

import com.nttdata.movement.model.document.Movement;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
public class MovementCreatedEvent extends Event<Movement> {

}
