package com.pedrovbo.bootcamp.services;


import com.pedrovbo.bootcamp.model.Dev;
import com.pedrovbo.bootcamp.repositories.DevRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class DevService {

    final DevRepository devRepository;

    public DevService(DevRepository devRepository){
        this.devRepository = devRepository;
    }

    @Transactional
    public Dev save(Dev dev) {
        return devRepository.save(dev);
    }

    public Page<Dev> findAll(Pageable pageable) {
        return devRepository.findAll(pageable);
    }

    public Optional<Dev> findById(Long id) {
        return devRepository.findById(id);
    }

    @Transactional
    public void delete(Dev dev) {
        devRepository.delete(dev);
    }
}
