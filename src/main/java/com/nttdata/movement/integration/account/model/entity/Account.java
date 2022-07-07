package com.nttdata.movement.integration.account.model.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Account {
    @Id
    private long idAccount;
    private long idCustomer;
    private long idProduct;
    private String number;
    private Float amount;
    private int limit;
    private String dateMovement;
}
