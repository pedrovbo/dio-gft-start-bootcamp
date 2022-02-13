package com.api.digitalbank.services;

import com.api.digitalbank.models.BankModel;
import com.api.digitalbank.repositories.BankRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class BankService {

    final BankRepository bankRepository;

    public BankService(BankRepository bankRepository){
        this.bankRepository = bankRepository;
    }

    @Transactional
    public BankModel save(BankModel bankModel){
        return bankRepository.save(bankModel);
    }

    public boolean existsByBankName(String bankName){
        return bankRepository.existsByBankName(bankName);
    }

    public Page<BankModel> findAll(Pageable pageable) {
        return bankRepository.findAll(pageable);
    }

    public Optional<BankModel> findById(UUID id) {
        return bankRepository.findById(id);
    }

    @Transactional
    public void delete(BankModel bankModel) {
        bankRepository.delete(bankModel);
    }
}
