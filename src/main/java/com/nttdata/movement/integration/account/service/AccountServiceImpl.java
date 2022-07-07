package com.nttdata.movement.integration.account.service;

import com.nttdata.movement.integration.account.model.entity.Account;
import com.nttdata.movement.integration.account.model.service.AccountService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Mono;
@Service
public class AccountServiceImpl implements AccountService {
    Logger log = LoggerFactory.getLogger(AccountServiceImpl.class);
    @Autowired
    private WebClient.Builder webClient;
    @Override
    public Mono<Account> getAccount(long idAccount) {
        String uriGet = "/api/account/{idAccount}";

        return webClient.build().get()
                .uri(uriGet, idAccount)
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToMono(Account.class);
    }

    @Override
    public Mono<Account> updateAccount(Account account) {
        String uriPut = "/api/account/";
        return webClient.build().put()
                .uri(uriPut, account)
                .accept(MediaType.APPLICATION_JSON)
                .bodyValue(account)
                .retrieve().bodyToMono(Account.class).defaultIfEmpty(new Account());
    }
}
