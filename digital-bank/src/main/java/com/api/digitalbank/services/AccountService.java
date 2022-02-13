package com.api.digitalbank.services;

import com.api.digitalbank.models.AccountModel;
import com.api.digitalbank.repositories.AccountRepository;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
public class AccountService {

    final AccountRepository accountRepository;

    public AccountService(AccountRepository accountRepository) {
        this.accountRepository = accountRepository;
    }

    @Transactional
    public AccountModel save(AccountModel accountModel) {
        return accountRepository.save(accountModel);
    }

    public boolean existsByAgency(int agency) {
        return accountRepository.existsByAgency(agency);
    }

    public boolean existsByNumber(int accountNumber) {
        return accountRepository.existsByNumber(accountNumber);
    }

    @Transactional
    public void delete(AccountModel accountModel) {
        accountRepository.delete(accountModel);
    }

}
