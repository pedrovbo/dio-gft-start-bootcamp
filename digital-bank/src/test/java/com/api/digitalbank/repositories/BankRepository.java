package com.api.digitalbank.repositories;

import com.api.digitalbank.models.BankModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface BankRepository extends JpaRepository<BankModel, UUID> {

    boolean existsByBankName(String bankName);

}
