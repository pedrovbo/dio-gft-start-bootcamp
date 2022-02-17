package com.pedrovbo.bootcamp.services;

import com.pedrovbo.bootcamp.model.Bootcamp;
import com.pedrovbo.bootcamp.model.Curso;
import com.pedrovbo.bootcamp.repositories.CursoRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;

@Service
public class CursoService {

    final CursoRepository cursoRepository;

    public CursoService(CursoRepository cursoRepository) {
        this.cursoRepository = cursoRepository;
    }

    @Transactional
    public Curso save(Curso curso) { return cursoRepository.save(curso);}

    public Page<Curso> findAll(Pageable pageable) {
        return cursoRepository.findAll(pageable);
    }

    public Optional<Curso> findById(Long id) {
        return cursoRepository.findById(id);
    }

    @Transactional
    public void delete(Curso curso) {
        cursoRepository.delete(curso);
    }
}
