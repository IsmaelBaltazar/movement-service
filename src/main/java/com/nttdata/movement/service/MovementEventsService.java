package com.nttdata.movement.service;

import com.nttdata.movement.event.Event;
import com.nttdata.movement.event.EventType;
import com.nttdata.movement.event.MovementCreatedEvent;
import com.nttdata.movement.model.document.Movement;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.UUID;

@Component
public class MovementEventsService {

    @Autowired
    private KafkaTemplate<String, Event<?>> producer;

    //@Value("${topic.movement}")
    private String topicCustomer="MovementTopic";

    public void publish(Movement movement) {
        MovementCreatedEvent created = new MovementCreatedEvent();
        created.setData(movement);
        created.setId(UUID.randomUUID().toString());
        created.setType(EventType.CREATED);
        created.setDate(new Date());
        this.producer.send(topicCustomer, created);
    }
}
