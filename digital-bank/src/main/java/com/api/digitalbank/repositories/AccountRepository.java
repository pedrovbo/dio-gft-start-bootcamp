package com.api.digitalbank.repositories;

import com.api.digitalbank.models.AccountModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AccountRepository extends JpaRepository<AccountModel, UUID> {

    boolean existsByAgency(int agency);
    boolean existsByNumber(int accountNumber);

}
