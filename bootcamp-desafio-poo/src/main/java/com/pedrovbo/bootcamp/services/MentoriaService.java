package com.pedrovbo.bootcamp.services;

import com.pedrovbo.bootcamp.model.Bootcamp;
import com.pedrovbo.bootcamp.model.Mentoria;
import com.pedrovbo.bootcamp.repositories.MentoriaRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class MentoriaService {

    final MentoriaRepository mentoriaRepository;

    public MentoriaService(MentoriaRepository mentoriaRepository) {
        this.mentoriaRepository = mentoriaRepository;
    }

    @Transactional
    public Mentoria save(Mentoria mentoria) {
        return mentoriaRepository.save(mentoria);
    }


    public Page<Mentoria> findAll(Pageable pageable) {
        return mentoriaRepository.findAll(pageable);
    }

    public Optional<Mentoria> findById(Long id) {
        return mentoriaRepository.findById(id);
    }

    @Transactional
    public void delete(Mentoria mentoria) {
        mentoriaRepository.delete(mentoria);
    }

}
