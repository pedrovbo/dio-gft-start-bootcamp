package com.pedrovbo.bootcamp.services;

import com.pedrovbo.bootcamp.model.Bootcamp;
import com.pedrovbo.bootcamp.repositories.BootcampRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@Service
public class BootcampService {

    final BootcampRepository bootcampRepository;

    public BootcampService(BootcampRepository bootcampRepository){
        this.bootcampRepository = bootcampRepository;
    }

    @Transactional
    public Bootcamp save(Bootcamp bootcamp) {
        return bootcampRepository.save(bootcamp);
    }

    public boolean existsByName(String nome) {
        return bootcampRepository.existsByNome(nome);
    }

    public Page<Bootcamp> findAll(Pageable pageable) {
        return bootcampRepository.findAll(pageable);
    }

    public Optional<Bootcamp> findById(Long id) {
        return bootcampRepository.findById(id);
    }

    @Transactional
    public void delete(Bootcamp bootcamp) {
        bootcampRepository.delete(bootcamp);
    }
}
