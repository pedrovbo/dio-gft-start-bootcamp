package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Emprestimo;
import com.pedrovbo.emprestimolivros.model.Livro;
import com.pedrovbo.emprestimolivros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class LivroServiceImpl implements LivroService{

    @Autowired
    private LivroRepository livroRepository;

    @Override
    public Livro createLivro(Livro livro) {
        return null;
    }

    @Override
    public List<Livro> getAllLivros() {
        return null;
    }

    @Transactional
    public Livro save(Livro livro){
        return livroRepository.save(livro);
    }

    public Page<Livro> findAll(Pageable pageable){
        return livroRepository.findAll(pageable);
    }

    public Optional<Livro> findById(Long id){
        return livroRepository.findById(id);
    }

    @Transactional
    public void delete(Livro livro){
        livroRepository.delete(livro);
    }
}
