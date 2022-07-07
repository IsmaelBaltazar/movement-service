package com.nttdata.movement.service;

import com.nttdata.movement.model.document.Sequence;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.FindAndModifyOptions;
import org.springframework.data.mongodb.core.ReactiveMongoOperations;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Objects;

@Service
public class SequenceGeneratorService {
    @Autowired(required=true)
    private ReactiveMongoOperations mongoOperations;
    Logger log = LoggerFactory.getLogger(SequenceGeneratorService.class);
    public Integer getSequenceNumber(String sequenceName){
        Query query = new Query(Criteria.where("id").is(sequenceName));
        Update update = new Update().inc("seqNumber",1);
        try {
            return mongoOperations.findAndModify(query, update, FindAndModifyOptions.options().returnNew(true).upsert(true), Sequence.class)
                    .toFuture().get().getSeqNumber();
        }catch (Exception e){
            log.error("Error al obtener nuevo id: "+e.getMessage());
            return 0;
        }
    }
}
