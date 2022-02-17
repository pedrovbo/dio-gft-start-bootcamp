package com.api.digitalbank.services;

import com.api.digitalbank.models.AccountModel;
import com.api.digitalbank.repositories.AccountRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

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

    public boolean existsByAccountNumber(int accountNumber) {
        return accountRepository.existsByAccountNumber(accountNumber);
    }


    public Page<AccountModel> findAll(Pageable pageable) {
        return accountRepository.findAll(pageable);
    }

    public Optional<AccountModel> findById(UUID id) {
        return accountRepository.findById(id);
    }

    @Transactional
    public void delete(AccountModel accountModel) {
        accountRepository.delete(accountModel);
    }

    // TODO: Implementar saque, depósito e transferência
    /*public void withdraw(double value) {
        this.balance -= value;
    }


    public void deposit(double value) {
        this.balance += value;
    }


    public void transfer(double value, IAccount destinyAccount) {
        this.withdraw(value);
        destinyAccount.deposit(value);
    }


    public void printExtract() {

    }*/
}

