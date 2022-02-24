package com.pedrovbo.emprestimolivros.service;

import com.pedrovbo.emprestimolivros.model.Livro;

import java.util.List;

public interface LivroService {

    Livro createLivro(Livro livro);
    List<Livro> getAllLivros();
}
