package com.nttdata.movement.model.document;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.annotation.Transient;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Document(collection = "movements")
public class Movement {
    @Transient
    public static final String SEQUENCE_NAME = "movement_sequence";

    @Id
    private long idMovement;
    private long idAccount;
    private String name;
    private String date;
    private String time;
    private Float amount;
}
