package com.api.digitalbank.services;

import com.api.digitalbank.models.ClientModel;
import com.api.digitalbank.repositories.ClientRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;
import java.util.UUID;

@Service
public class ClientService {

    final ClientRepository clientRepository;

    public ClientService(ClientRepository clientRepository){
        this.clientRepository = clientRepository;
    }

    @Transactional
    public ClientModel save(ClientModel clientModel){
        return clientRepository.save(clientModel);
    }

    public boolean existsByCpf(String cpf){
        return clientRepository.existsByCpf(cpf);
    }

    public boolean existsByName(String name){
        return clientRepository.existsByName(name);
    }

    public Page<ClientModel> findAll(Pageable pageable) {return clientRepository.findAll(pageable);}

    public Optional<ClientModel> findById(UUID id) { return clientRepository.findById(id);}

    @Transactional
    public void delete(ClientModel clientModel){ clientRepository.delete(clientModel);}

}
