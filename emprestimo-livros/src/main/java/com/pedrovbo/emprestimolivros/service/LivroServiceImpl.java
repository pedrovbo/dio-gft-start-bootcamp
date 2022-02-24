package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Livro;
import com.pedrovbo.emprestimolivros.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
}
