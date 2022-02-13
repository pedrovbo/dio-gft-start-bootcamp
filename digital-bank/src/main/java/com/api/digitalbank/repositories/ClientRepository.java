package com.api.digitalbank.repositories;

import com.api.digitalbank.models.ClientModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface ClientRepository extends JpaRepository<ClientModel, UUID> {

    boolean existsByCpf(String cpf);
    boolean existsByName(String name);

}
