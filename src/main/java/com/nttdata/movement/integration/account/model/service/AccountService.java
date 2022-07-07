package com.nttdata.movement.integration.account.model.service;

import com.nttdata.movement.integration.account.model.entity.Account;
import reactor.core.publisher.Mono;

public interface AccountService {
    Mono<Account> getAccount(long idAccount);
    Mono<Account> updateAccount(Account account);
}
