package com.pedrovbo.bootcamp.services;

import com.pedrovbo.bootcamp.model.Bootcamp;
import com.pedrovbo.bootcamp.model.Conteudo;
import com.pedrovbo.bootcamp.repositories.ConteudoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class ConteudoService {

    final ConteudoRepository conteudoRepository;

    public ConteudoService(ConteudoRepository conteudoRepository) {
        this.conteudoRepository = conteudoRepository;
    }

    @Transactional
    public Conteudo save(Conteudo conteudo) {
        return conteudoRepository.save(conteudo);
    }


    public Page<Conteudo> findAll(Pageable pageable) {
        return conteudoRepository.findAll(pageable);
    }

    public Optional<Conteudo> findById(Long id) {
        return conteudoRepository.findById(id);
    }

    @Transactional
    public void delete(Conteudo conteudo) {
        conteudoRepository.delete(conteudo);
    }
}
